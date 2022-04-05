package ru.dmitriiromanov.lessons.stream.modifiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Если мы хотим получить Stream уникальных элеметов, мы можем воспользоваться методом distinct().
 * Использование метода distinct() предполагает что элементы Stream-a реализовывают метод equals()
 */

public class MainApp {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "a", "b");

        strings.stream()
                .distinct()
                .forEach(System.out::println); //output a b c d

        //Comparator<String> comparator = (str_1, str_2) -> str_1.length() - str_2.length();
        Comparator<String> comparator1 = Comparator.comparingInt(String::length);
        List<String> stringList = new ArrayList<>(Arrays.asList("ab", "c", "bcd"));
        stringList.sort(comparator1.reversed());
        System.out.println(stringList);

        /**
         * sequential() был введен для того, чтобы из parallel можно было обратно получить sequential Stream.
         */
        strings.parallelStream()
                .sequential()
                .forEach(System.out::println);
    }
}
