package ru.dmitriiromanov.lessons.stream.optional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MainApp {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("John");
        System.out.println(name); // output Optional[John]

        String john = null;
        Optional<String> nameOfNullable = Optional.ofNullable(john);
        System.out.println(nameOfNullable); // output Optional.empty

        Optional<String> emptyOptional = Optional.empty();

        System.out.println(emptyOptional.isPresent()); // false

        name.ifPresent(System.out::println); // John
        emptyOptional.ifPresent(System.out::println); // empty

        System.out.println("--------------------------------");

        System.out.println(name.orElse("blank")); // John
        System.out.println(emptyOptional.orElse("blank")); // blank

        System.out.println("--------------------------------");

        System.out.println(name.orElseGet(() -> "blank"));
        System.out.println(emptyOptional.orElseGet(() -> "blank"));

        System.out.println("--------------------------------");

        String nameValue = name.orElseThrow(() -> new RuntimeException());
        System.out.println(nameValue); // output John
        //Object emptyValue = emptyOptional.orElseThrow(() -> new RuntimeException()); //java.lang.RuntimeException

        System.out.println("--------------------------------");

        List<String> names = List.of("John", "Aria", "Tyrion", "Daenerys", "Eddard"); // java 9 and up optional stream
        names.stream()
                .map(MainApp::getSurname)
                .flatMap(Optional::stream)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

    }

    private static final Map<String, String> humans = Map.of(
            "John", "Snow",
            "Aria", "Stark",
            "Daenerys", "Targaryen"
    );

    private static Optional<String> getSurname(String name) {
        return Optional.ofNullable(humans.get(name));
    }
}
