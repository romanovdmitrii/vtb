package ru.dmitriiromanov.lessons.threads;

public class MainAppDoubleCounter {

    private long count1;
    private long count2;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public long getCount1() {
        return count1;
    }

    public long getCount2() {
        return count2;
    }

    public void increment1() {
        synchronized (lock1) {
            count1++;
        }
    }

    public void increment2() {
        synchronized (lock2) {
            count2++;
        }
    }
}
