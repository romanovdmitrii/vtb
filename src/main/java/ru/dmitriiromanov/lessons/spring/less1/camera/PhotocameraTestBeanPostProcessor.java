package ru.dmitriiromanov.lessons.spring.less1.camera;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PhotocameraTestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Camera) {
            System.out.println("do test photo");
//            ((Camera) bean).doPhotograph();
        }
        return bean;
    }
}
