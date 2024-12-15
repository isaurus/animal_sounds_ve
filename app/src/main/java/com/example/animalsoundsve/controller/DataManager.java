package com.example.animalsoundsve.controller;

import com.example.animalsoundsve.R;
import com.example.animalsoundsve.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private final List<Animal> dataSet = new ArrayList<>();

    public DataManager(){
        loadData();
    }

    public void loadData(){
        dataSet.add(new Animal(R.drawable.chicken_img, R.raw.chicken_sound));
        dataSet.add(new Animal(R.drawable.cow_img, R.raw.cow_sound));
        dataSet.add(new Animal(R.drawable.donkey_img, R.raw.donkey_sound));
        dataSet.add(new Animal(R.drawable.horse_img, R.raw.horse_sound));
        dataSet.add(new Animal(R.drawable.pig_img, R.raw.pig_sound));
        dataSet.add(new Animal(R.drawable.rabbit_img, R.raw.rabbit_sound));
        dataSet.add(new Animal(R.drawable.bear_img, R.raw.bear_sound));
        dataSet.add(new Animal(R.drawable.lion_img, R.raw.lion_sound));
        dataSet.add(new Animal(R.drawable.monkey_img, R.raw.monkey_sound));
        dataSet.add(new Animal(R.drawable.snake_img, R.raw.snake_sound));
        dataSet.add(new Animal(R.drawable.tiger_img, R.raw.tiger_sound));
        dataSet.add(new Animal(R.drawable.wolf_img, R.raw.wolf_sound));
    }

    public List<Animal> getFarmAnimals(){
        return dataSet.subList(0, 6);
    }

    public List<Animal> getWildAnimals(){
        return dataSet.subList(6, 12);
    }
}
