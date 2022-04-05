package ru.dmitriiromanov.lessons.stream.match;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean match = numbers.stream()
                .anyMatch(number -> number % 2 == 0); // есть ли в Stream-e четное число

        System.out.println(match); //output true

        boolean match1 = numbers.stream()
                .allMatch(number -> number % 2 == 0); // все ли числа в Stream-e четные

        System.out.println(match1); //output false

        boolean match2 = numbers.stream()
                .noneMatch(number -> number < 0); // все ли числа в Stream-e отрицательные

        System.out.println(match2); //output true
    }
}
