package ru.dmitriiromanov.lessons.spring.less1;

import lombok.Setter;

@Setter
public class JavaCodeCreator implements CodeCreator {

    private ClassNameGenerator classNameGenerator;

    @Override
    public String getClassExample() {
        return "public class " + classNameGenerator.generateClassName() + " {\n\n}";
    }
}
