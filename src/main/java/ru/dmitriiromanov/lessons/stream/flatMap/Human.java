package ru.dmitriiromanov.lessons.stream.flatMap;

import lombok.Data;

import java.util.List;

@Data
public class Human {
    private final String name;
    private final List<String> pets;
}
