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
        return this.name;
    }

    public float getCarbsInGrams() {
        return this.carbs / 4;
    }

    public float getFatsInGrams() {
        return this.fats / 9;
    }

    public float getProteinInGrams() {
        return this.protein / 4;
    }

    public int getPortionInGrams() {
        return this.portionInGrams;
    }

    public void setPortionInGrams(int portionInGrams) {
        this.portionInGrams = portionInGrams;
    }

    public float getCarbs() {
        return this.carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getFats() {
        return this.fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getProtein() {
        return this.protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCalories() {
        return this.calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " name='" + name + '\'' +
                ", carbs=" + getCarbs() +
                ", fats=" + getFats() +
                ", protein=" + getProtein() +
                '}';
    }
}
