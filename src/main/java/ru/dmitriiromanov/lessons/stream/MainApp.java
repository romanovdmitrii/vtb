package ru.dmitriiromanov.lessons.stream;

public class MainApp {
    public static void main(String[] args) {
        doSomething(() -> {
            System.out.println("run");
        });

        doSomething(() -> {
            System.out.println("stop");
        });

        doSomething(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public static void doSomething(Runnable runnable) {
        runnable.run();
    }
}
