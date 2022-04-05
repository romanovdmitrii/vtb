package ru.dmitriiromanov.lessons.threads;

import java.util.concurrent.CountDownLatch;

public class MainAppCountDownLatch {
    public static void main(String[] args) {
        final int THREAD_COUNT = 16;

        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        System.out.println("start");

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep((long) (200 * w + (Math.random() * 500)));
                    System.out.println("thread # " + w +" ready");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
