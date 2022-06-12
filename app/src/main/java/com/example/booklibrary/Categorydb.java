package com.example.booklibrary;

public class Categorydb {
    public Categorydb(String category_name) {
        this.category_name = category_name;
    }

    private  String category_name;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
