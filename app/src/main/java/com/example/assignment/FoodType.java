package com.example.assignment;

import java.util.List;

public class FoodType {
    private String name;
    private List<Meals> list;

    public FoodType(String name,List<Meals> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meals> getList() {
        return list;
    }

}
