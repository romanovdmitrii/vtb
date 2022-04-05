package ru.dmitriiromanov.lessons;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class TestClass {
    public static void main(String[] args) {

        Function<String, String> trimChange = String::trim;
        String str = trimChange
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");
        System.out.println(str);
        List<String> list = new LinkedList<>();

        /*Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .dropWhile(n -> n < 5)
                .forEach(System.out::println);*/

        System.out.println((int) (Math.random() * 4));
        System.out.println(TEST.ABC);
    }
}

enum TEST{
    ABC, DIF, GH;
}