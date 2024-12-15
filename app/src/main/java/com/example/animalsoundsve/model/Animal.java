package com.example.animalsoundsve.model;

public class Animal {

    private int drawableResource;
    private int rawResource;

    public Animal(int drawableResource, int rawResource){
        this.drawableResource = drawableResource;
        this.rawResource = rawResource;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public int getRawResource() {
        return rawResource;
    }

    public void setRawResource(int rawResource) {
        this.rawResource = rawResource;
    }
}
