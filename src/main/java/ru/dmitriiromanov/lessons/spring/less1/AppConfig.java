package ru.dmitriiromanov.lessons.spring.less1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.dmitriiromanov.lessons.spring.less1")
public class AppConfig {

    /*
        <bean id="simpleBean" class="ru.dmitriiromanov.lessons.spring.less1.SimpleBean"/>

        <bean id="javaCodeCreator" class="ru.dmitriiromanov.lessons.spring.less1.JavaCodeCreator">
            <property name="classNameGenerator">
                <ref bean="animalsClassNameGenerator" />
            </property>
        </bean>
     */

    @Bean
    public SimpleBean simpleBean() {
        SimpleBean simpleBean = new SimpleBean();
        return simpleBean;
    }

    @Bean
    public ClassNameGenerator animalsClassNameGenerator() {
        ClassNameGenerator generator = new AnimalsClassNameGenerator();
        return generator;
    }

    @Bean
    public CodeCreator javaCodeCreator() {
        JavaCodeCreator codeCreator = new JavaCodeCreator();
        codeCreator.setClassNameGenerator(animalsClassNameGenerator());
        return codeCreator;
    }
}
