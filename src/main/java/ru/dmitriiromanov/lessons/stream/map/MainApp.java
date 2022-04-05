package ru.dmitriiromanov.lessons.stream.map;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        Function<String, Integer> strToLen = String::length;
        Function<String, Integer> strToLength = s -> s.length();
        Predicate<Integer> numberFilter = n -> n % 2 == 0;
        Function<Integer, Boolean> filter = n -> n % 2 == 0;
        Comparator<String> comparator = (str_1, str_2) -> str_1.length() - str_2.length();
        Comparator<String> comparator1 = Comparator.comparingInt(String::length);
        List<String> stringList = new ArrayList<>(Arrays.asList("ab", "c", "bcd"));
        stringList.sort(comparator.reversed());
        System.out.println(stringList);

        Stream.of(1, 2, 3, 4, 5).map(n -> n % 2 == 0);
        Stream.of(1, 2, 3, 4, 5).map(filter);
        Stream.of(1, 2, 3, 4, 5).map((n) -> numberFilter);

        int sum = Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(num -> num + 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        Function<String, String> trimChange = String::trim;
        String str = trimChange
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");
        System.out.println(str);

        String[] str_arr = {"abc def abc cba", "abc def abc cba"};
        System.out.println(Arrays.stream(str_arr)
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.joining(", ", " ", "")));

        Optional<String> name = Optional.of("JOHN");
        System.out.println(name.map(String::toLowerCase));  // output Optional[john]

        Optional<String> empty = Optional.empty();
        System.out.println(empty.map(String::toLowerCase)); // output Optional.empty


    }
}
