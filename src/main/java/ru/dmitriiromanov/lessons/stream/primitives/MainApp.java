package ru.dmitriiromanov.lessons.stream.primitives;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MainApp {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        LongStream longStream = LongStream.of(5, 6, 7, 8);
        DoubleStream doubleStream = DoubleStream.of(9, 10, 11, 12);

        IntStream intStream1 = IntStream.range(1, 100); // от 1 до 99
        LongStream longStream1 = LongStream.range(2, 200); // от 1 до 99
        //DoubleStream doubleStream1 = DoubleStream.range(3, 300); // метода нет, не компилируется

        IntStream intStream2 = IntStream.rangeClosed(1, 100); // от 1 до 100
        LongStream longStream2 = LongStream.rangeClosed(2, 200); // от 1 до 100
        //DoubleStream doubleStream2 = DoubleStream.rangeClosed(3, 300); // метода нет, не компилируется

        /**
         * IntStream можно преобразовать в LongStream, либо в DoubleStream.
         * LongStream только в DoubleStream.
         * DoubleStream назад не преобразовывается.
         */
        DoubleStream doubleStream3 = IntStream.rangeClosed(1, 100)
                .asLongStream()
                .asDoubleStream();

        int[] ints = IntStream.of(1, 2).toArray(); // [1, 2]
        long[] longs = LongStream.of(3, 4).toArray(); // [3, 4]
        double[] doubles = DoubleStream.of(5, 6).toArray(); // [5.0, 6.0]

        int intSum = IntStream.of(1, 2).sum(); // 3
        long longSum = LongStream.of(3, 4).sum(); // 7
        double doubleSum = DoubleStream.of(5, 6).sum(); // 11

        OptionalDouble intAverage = IntStream.of(1, 2).average(); // 1.5 // OptionalDouble[1.5]
        OptionalDouble longAverage = LongStream.of(3, 4).average(); // 3.5
        OptionalDouble doubleAverage = DoubleStream.of(5, 6).average(); // 5.5

    }
}
