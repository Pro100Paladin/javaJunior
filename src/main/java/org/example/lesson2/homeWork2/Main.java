package org.example.lesson2.homeWork2;

import java.lang.reflect.Method;

/**
 * Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
 */

public class Main {

    public static void main(String[] args) {

        Class<String> clazz = String.class;
        Method[] methods = clazz.getDeclaredMethods();

        int num = 0;
        for (Method method : methods) {
            num++;

            System.out.println("метод под № " + num + ": " + method.getName());
        }
    }
}
