package ru.dmitriiromanov.lessons.threads;

import java.util.concurrent.Semaphore;

public class MainAppSimpleSemaphore {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(4); // limit treads

        Runnable limitedCall = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                int time = 3 + (int) (Math.random() * 4);
                int num = count++;

                try {
                    semaphore.acquire(); // limit -1
                    System.out.println("thread # " + num + " started work");
                    Thread.sleep(time * 1000L);
                    System.out.println("thread # " + num + " end work");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // limit + 1
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }
}
