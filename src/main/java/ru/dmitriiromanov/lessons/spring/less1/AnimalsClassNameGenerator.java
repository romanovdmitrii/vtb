package ru.dmitriiromanov.lessons.spring.less1;

public class AnimalsClassNameGenerator implements ClassNameGenerator {
    @Override
    public String generateClassName() {
        String[] names = {"Cat", "Dog", "Horse", "Bull"};
        return names[(int) (Math.random() * 4)]; // 0 - 3
    }
}
