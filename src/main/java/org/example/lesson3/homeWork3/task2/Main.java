package org.example.lesson3.homeWork3.task2;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        // Сериализация
        try (FileOutputStream fileOut = new FileOutputStream("student.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            Student studentOne = new Student("Alex", 18, 4.5);
            Student studentTwo = new Student("Bob", 17, 3.7);
            Student studentTree = new Student("Candy", 21, 4.9);

            out.writeObject(studentOne);
            out.writeObject(studentTwo);
            out.writeObject(studentTree);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация
        try (FileInputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Student studentOne = (Student) in.readObject();
            System.out.println("Имя студента: " + studentOne.getName());
            System.out.println("Возраст студента: " + studentOne.getAge());
            System.out.println("Средний балл студента: " + studentOne.getGPA());

            Student studentTwo = (Student) in.readObject();
            System.out.println("Имя студента: " + studentTwo.getName());
            System.out.println("Возраст студента: " + studentTwo.getAge());
            System.out.println("Средний балл студента: " + studentTwo.getGPA());

            Student studentTree = (Student) in.readObject();
            System.out.println("Имя студента: " + studentTree.getName());
            System.out.println("Возраст студента: " + studentTree.getAge());
            System.out.println("Средний балл студента: " + studentTree.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

