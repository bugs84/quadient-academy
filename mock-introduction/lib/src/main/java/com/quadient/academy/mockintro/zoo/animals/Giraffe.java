package com.quadient.academy.mockintro.zoo.animals;

public class Giraffe {
    private String name;
    private int age;
    private double height;
    private int weight;

    public Giraffe(String name, int age, double heightInMeters, int weight) {
        this.name = name;
        this.age = age;
        this.height = heightInMeters;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
