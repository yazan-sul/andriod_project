package com.example.assignment;


public class Meals {
    private String name;
    private int calories;
    private int imageResId;
    public Meals(String name,int calories, int imageResId) {
        this.name = name;
        this.calories = calories;
        this.imageResId = imageResId;
    }
    public int getImageResId() {
        return imageResId;
    }
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}
