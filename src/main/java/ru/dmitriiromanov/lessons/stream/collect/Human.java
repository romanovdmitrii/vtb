package ru.dmitriiromanov.lessons.stream.collect;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Human {

    private String name, surname;
    private int friendsAmount;
}
