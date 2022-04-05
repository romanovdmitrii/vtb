package ru.dmitriiromanov.lessons.stream.vtbHomework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * из массива строк найти наиболее часто встречаемое
 */

public class MainApp {
    public static void main(String[] args) {
        String [] arrayStrings = {"A", "B", "C", "A", "A", "C", "A"};
        System.out.println(Arrays.stream(arrayStrings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                //collect(Collectors.groupingBy(str -> str, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                //.get().getKey()
        );

    }
}
