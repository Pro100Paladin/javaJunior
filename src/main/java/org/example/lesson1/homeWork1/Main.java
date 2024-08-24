package org.example.lesson1.homeWork1;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

public class Main {

    public static void main(String[] args) {
        out.println("начало программы: ");

        int[] numbers = IntStream.generate(() -> new Random().nextInt(100)).limit(10).toArray();
        Arrays.stream(numbers).forEach(out::println);

        Arrays.stream(numbers).filter(i -> i % 2 == 0).average().stream().forEach(out::print);
    }
}

