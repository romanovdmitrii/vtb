package ru.dmitriiromanov.lessons.stream.debug;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .peek(System.out::println)
                .forEach(n -> doSomeStaff(n));
    }
    private static void debug(Integer n) {
        System.out.println(n);
    }

    private static void doSomeStaff(Integer n) {

    }
}
