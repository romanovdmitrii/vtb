package ru.dmitriiromanov.lessons.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainAppLockExample {
    public static void main(String[] args) {

        final Lock lock = new ReentrantLock();

        new Thread(() -> {
            System.err.println("before lock one");
            lock.lock();
            System.err.println("Get lock one");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.err.println("End one");
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.err.println("Begin two");
            try {
                if (lock.tryLock(3L, TimeUnit.SECONDS)) {
                    try {
                        System.err.println("Get lock two");
                        try {
                            Thread.sleep(8000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        System.err.println("End two");
                        lock.unlock();
                    }
                } else {
                    System.err.println("Ну и ладно .. ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
