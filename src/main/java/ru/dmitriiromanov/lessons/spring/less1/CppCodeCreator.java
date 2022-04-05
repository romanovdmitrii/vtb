package ru.dmitriiromanov.lessons.spring.less1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CppCodeCreator implements CodeCreator {

    ClassNameGenerator classNameGenerator;

    @Override
    public String getClassExample() {
        return "public class " + classNameGenerator.generateClassName() + "{\n\n}";
    }
}
