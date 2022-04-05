package ru.dmitriiromanov.lessons.spring.less1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotatedBean {

    private final SimpleBean simpleBean;

    public AnnotatedBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }

    public void example() {
        simpleBean.doSomething();
    }
}
