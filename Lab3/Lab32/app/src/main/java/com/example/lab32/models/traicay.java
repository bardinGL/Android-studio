package com.example.lab32.models;

public class traicay {
    private String name;
    private String description;
    private int imageResource;

    public traicay(String name, String description, int imageResource) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
