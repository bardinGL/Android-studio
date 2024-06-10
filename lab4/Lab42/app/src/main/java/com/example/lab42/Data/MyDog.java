package com.example.lab42.Data;

import java.io.Serializable;

public class MyDog implements Serializable {
    String name;
    int age;

    public MyDog() {
    }

    public MyDog(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
