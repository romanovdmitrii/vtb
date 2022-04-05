package ru.dmitriiromanov.lessons.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce((left, right) -> left + right);
        sum.ifPresent(System.out::println); //output 11

        Integer sum2 = numbers.stream()
                .reduce(10, Integer::sum);
                //.reduce(10, (left, right) -> left + right);
        System.out.println(sum2); //output 21

        System.out.println(numbers.stream()
                .reduce(Integer.MAX_VALUE, (left, right) -> left < right ? left : right));

        List<Integer> numbersList = Arrays.asList(1, 2, 3);
        // 1*10 + 2*10 + 3*20
        Integer sum3 = numbersList.stream()
                .reduce(10, (identity, val) -> identity * val);
        System.out.println(sum3); //output 60
    }
}
