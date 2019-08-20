package com.olehpodolin.model;

public class Product {

    private String name;
    private float carbs;
    private float fats;
    private float protein;
    private float calories;
    private int portionInGrams = 100;

    public Product(String name, float carbs, float fats, float protein) {
        this.name = name;
        this.carbs = carbs;
        this.fats = fats;
        this.protein = protein;
        this.calories = carbs + fats + protein;
    }

    public Product() {}

    public String getName() {
        return name;
    }

    public float getCarbsInGrams() {
        return carbs / 4;
    }

    public float getFatsInGrams() {
        return fats / 9;
    }

    public float getProteinInGrams() {
        return protein / 4;
    }

    public int getPortionInGrams() {
        return portionInGrams;
    }

    public void setPortionInGrams(int portionInGrams) {
        this.portionInGrams = portionInGrams;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " name='" + name + '\'' +
                ", carbs=" + getCarbsInGrams() +
                ", fats=" + getFatsInGrams() +
                ", protein=" + getProteinInGrams() +
                '}';
    }
}
