package ru.dmitriiromanov.lessons.stream.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class MainApp {
    public static void main(String[] args) {
        List<Human> humans = asList(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        List<String> petNames = humans.stream()
                .map(human -> human.getPets()) //преобразовываем Stream<Human> в Stream<List<Pet>>
                .flatMap(pets -> pets.stream()) //"разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .collect(Collectors.toList());
        System.out.println(petNames); // output [Buddy, Lucy, Frankie, Rosie, Simba, Tilly]

        List<String> petNamesFlat = humans.stream()
                .flatMap(human -> human.getPets().stream())
                .collect(Collectors.toList());
        System.out.println(petNamesFlat); // output [Buddy, Lucy, Frankie, Rosie, Simba, Tilly]

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};

        int[] newArr = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream) //преобразовываем IntStream<int[]> в IntStream
                .toArray();
        System.out.println(Arrays.toString(newArr));

    }
}
