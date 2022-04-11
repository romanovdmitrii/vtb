package ru.dmitriiromanov.lessons.spring.less1.camera;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.dmitriiromanov.lessons.spring.less1.camera")
public class AppConfig {

    @Bean(name = "cameraRoll")
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

    @Bean(name = "camera")
    public CameraImpl camera(CameraRoll cameraRoll) {
        CameraImpl camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
