package ru.dmitriiromanov.lessons.spring.less1.camera;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        /*CameraImpl camera = new CameraImpl();
        camera.setCameraRoll(new ColorCameraRoll());
        camera.doPhotograph();*/

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera = context.getBean("camera", Camera.class);
        camera.doPhotograph();
    }
}
