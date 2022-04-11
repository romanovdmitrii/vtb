package ru.dmitriiromanov.lessons.spring.less1.camera;

public class CameraImpl implements Camera {

    public CameraRoll cameraRoll;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public void doPhotograph() {
        System.out.println("do photo");
        cameraRoll.processing();
    }
}
