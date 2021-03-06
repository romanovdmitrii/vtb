package ru.dmitriiromanov.lessons.spring.less1.camera;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface UnproducableCameraRoll {
    Class usingCameraRollClass();
}
