package ru.dmitriiromanov.lessons.spring.less1.camera;

public interface CameraRoll {

    default void processing() {
        System.out.println("-1 photo");
    }
}
