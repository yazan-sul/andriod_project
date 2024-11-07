package com.example.assignment;

public class Profile {
    private int weight;
    private int height;
    private int age;
    private String gender;

    public Profile(int weight, int height, int age, String gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }
    public Profile(String weight, String height, String age, String gender) {
        this.weight = Integer.parseInt(weight);
        this.height = Integer.parseInt(height);
        this.age = Integer.parseInt(age);
        this.gender = gender;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
