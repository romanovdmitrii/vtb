package ru.dmitriiromanov.lessons.stream.limitAndSkip;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .limit(5)
                .forEach((num)-> System.out.print(num + " ")); //output 1 2 3 4 5

        System.out.println();

        numbers.stream()
                .skip(5)
                .forEach((num)-> System.out.print(num + " ")); //output 6 7 8 9 10

        numbers.stream()
                .skip(10)
                .forEach(System.out::println); //output is empty
    }
}