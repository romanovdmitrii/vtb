package ru.dmitriiromanov.lessons.stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainAppGrouping {

    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        Map<String, List<Human>> map = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname));
        System.out.println(map);

        Map<String, Long> map1 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.counting()));
        System.out.println(map1); //output {Lannister=2, Targaryen=2, Stark=3}

        Map<String, Integer> map2 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.summingInt(Human::getFriendsAmount)));
        System.out.println(map2); //output {Lannister=4, Targaryen=10, Stark=4}

        Map<String, Set<String>> map3 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, //группируем по фамилии
                        Collectors.mapping(Human::getName, Collectors.toSet()))); // собираем имена в Set
        System.out.println(map3);

        System.out.println(humans.stream()
                .map(Human::getName)
                .distinct()
                .collect(Collectors.joining(", ")));

    }
}
