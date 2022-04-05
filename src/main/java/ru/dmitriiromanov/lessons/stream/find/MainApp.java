package ru.dmitriiromanov.lessons.stream.find;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BLOB", "Java is the best", "Java 8", "Java 9", "Jacoco");

        System.out.println(list.stream()
                .filter(str -> str.contains("java"))
                .findFirst());

        System.out.println(list.parallelStream()
                .filter(s -> s.contains("Java"))
                .findAny());

        list.parallelStream()
                .filter(s -> s.contains("Java"))
                .findFirst()
                .ifPresent(System.out::println);
    }
}
