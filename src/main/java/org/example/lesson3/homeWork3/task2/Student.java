package org.example.lesson3.homeWork3.task2;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;

    /* Поле GPA (средний балл) объявлено как transient. Ключевое слово transient указывает на то, что это поле
    должно быть исключено из сериализации.

    В результате, при десериализации значения transient поля не восстанавливаются из сохраненного состояния.
    Вместо этого, по умолчанию присваивается значение по умолчанию для типа данных double, которое равно 0.0. */
    transient double GPA;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }
}