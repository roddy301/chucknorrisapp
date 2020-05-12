package com.dal.chucknorrisapp;

public class card {
    public int norrisImage;
    public String joke;

    public card(int image, String text){
        this.norrisImage = image;
        this.joke = text;
    }

    public int getNorrisImage() {
        return norrisImage;
    }

    public String getJoke() {
        return joke;
    }
}
