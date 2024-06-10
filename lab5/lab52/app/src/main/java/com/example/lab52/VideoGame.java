package com.example.lab52;

public class VideoGame {
    private String name;
    private String description;
    private String developer;
    private String imageURL;
    private int image;

    public VideoGame(String name, String description, String developer, String imageURL) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.imageURL = imageURL;
    }

    public VideoGame(String name, String description, String developer, int image) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.image = image;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
