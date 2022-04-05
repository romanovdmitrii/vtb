package ru.dmitriiromanov.lessons.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainAppCyclicBarrier {
    public static void main(String[] args) {
        final int THREAD_COUNT = 5;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            int w = i;
            new Thread(() -> {
                try {
                    System.out.println("processing " + w);
                    Thread.sleep(2000 + 500 * (int) (Math.random() * 10));
                    System.out.println("ready " + w);
                    cyclicBarrier.await();
                    System.out.println("go " + w);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
