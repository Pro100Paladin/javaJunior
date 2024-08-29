package org.example.lesson3.homeWork3.task1;

import java.io.*;

/**
 * Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализация и десериализацию этого класса в файл.
 * <p></p>
 *
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void serialize(String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName); // FileOutputStream используется для создания
            // выходного потока, который связывается с
            // указанным файлом;

            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); // ObjectOutputStream используется для
            // сериализация объектов и записи их в поток;

            /* Вызываем метод writeObject(this), передавая в него самого себя (this), чтобы сериализовать
            текущий объект класса Person и записать его в поток. */
            objectOut.writeObject(this);

            /* Закрываем ObjectOutputStream и FileOutputStream, чтобы освободить ресурсы и сохранить данные. */
            objectOut.close();
            fileOut.close();

            System.out.println("Объект сериализован и сохранен в файл");
        } catch (IOException e) {
            e.printStackTrace(); // Отчет об ошибке;
        }
    }

    public static Person deserialize(String fileName) {
        Person person = null;
        try {
            /* FileInputStream используется для создания входного потока, который связывается с указанным файлом. */
            FileInputStream fileIn = new FileInputStream(fileName);
            /* ObjectInputStream используется для чтения сериализованных объектов из потока. */
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            /* Вызываем метод readObject(), чтобы прочитать сериализованный объект из потока.
            Затем приводим его к типу Person, так как мы знаем, что по нему мы стали сериализовать ранее. */
            person = (Person) objectIn.readObject();
            /* Закрываем ObjectInputStream и FileInputStream, чтобы освободить ресурсы. */
            objectIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        /* Возвращаем восстановленный объект класса Person или null, если восстановление не удалось. */
        return person;
    }
}