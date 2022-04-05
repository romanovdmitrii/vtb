package ru.dmitriiromanov.lessons.spring.less1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpring {
    public static void main(String[] args) {

/*        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("springContext.xml");

        SimpleBean bean = context.getBean("simpleBean", SimpleBean.class);
        bean.doSomething();

        CodeCreator codeCreator = context.getBean("javaCodeCreator", CodeCreator.class);
        System.out.println(codeCreator.getClassExample());

        CodeCreator cpp = context.getBean("cppCodeCreator", CodeCreator.class);
        System.out.println(codeCreator.getClassExample());

        context.close();*/

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleBean simpleBean = context.getBean("simpleBean", SimpleBean.class);
        simpleBean.doSomething();

        JavaCodeCreator javaCodeCreator = context.getBean("javaCodeCreator", JavaCodeCreator.class);
        System.out.println(javaCodeCreator.getClassExample());

        AnnotatedBean annotatedBean = context.getBean("annotatedBean", AnnotatedBean.class);
        annotatedBean.example();

        ((AnnotationConfigApplicationContext) context).close();
    }
}
