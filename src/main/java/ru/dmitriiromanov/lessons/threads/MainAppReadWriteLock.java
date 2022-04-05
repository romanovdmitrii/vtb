package ru.dmitriiromanov.lessons.threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainAppReadWriteLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

        new Thread(() -> {
            rwLock.readLock().lock();
            System.out.println("Reading start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Reading end");
                rwLock.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            rwLock.writeLock().lock();
            System.out.println("Writing start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Writing end");
                rwLock.writeLock().unlock();
            }
        }).start();
    }
}
