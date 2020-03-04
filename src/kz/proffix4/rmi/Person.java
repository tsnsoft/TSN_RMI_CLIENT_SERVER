package kz.proffix4.rmi;

import java.io.Serializable;

// Класс "Персона" с сериализацией для поддержки RMI
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s (age=%s)", name, age);
    }

}
