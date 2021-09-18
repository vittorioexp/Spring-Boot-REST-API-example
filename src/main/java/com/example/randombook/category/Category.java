package com.example.randombook.category;

public class Category {

    private final int id_category;
    private final String name;

    public Category(int id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }

    public int getIdCategory() {
        return this.id_category;
    }

    public String getName() {
        return this.name;
    }

}
