package ru.dmitriiromanov.lessons.oop;

public interface Transport {

    default void start() {
        System.out.println("Начал движение");
    }

    default void stop() {
        System.out.println("Остановился");
    }
}
