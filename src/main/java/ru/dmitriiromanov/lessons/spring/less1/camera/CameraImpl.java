package ru.dmitriiromanov.lessons.spring.less1.camera;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void ready() {
        System.out.println("Фотоаппарат готов к использованию!");
    }
    /**
     * @PostConstruct – метод инициализации, вызываемый после создания объекта и внедрения зависимостей
     * (т.е. между методами postProcessBeforeInitialization и
     * postProcessAfterInitialization интерфейса BeanPostProcessor);
     * @PreDestroy – метод, вызываемый перед уничтожением бина.
     */
}
