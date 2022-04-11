package ru.dmitriiromanov.lessons.spring.less1.camera;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        CameraRoll.super.processing();
    }
}
