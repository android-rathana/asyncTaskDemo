package com.example.ratha.asyntaskdemo.entity;

/**
 * Created by ratha on 3/9/2018.
 */

public class Article {
    int id;
    String title;
    String date;
    int image;

    public Article(String title, String date, int image) {
        this.title = title;
        this.date = date;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
