package com.olehpodolin.model;

public class Product {

    private String name;
    private double carbs;
    private double fats;
    private double protein;
    private double calories;
    private double portionInGrams = 100;

    public Product(String name, double carbs, double fats, double protein) {
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

    public double getCarbsInGrams() {
        return this.carbs / 4;
    }

    public double getFatsInGrams() {
        return this.fats / 9;
    }

    public double getProteinInGrams() {
        return this.protein / 4;
    }

    public double getPortionInGrams() {
        return this.portionInGrams;
    }

    public void setPortionInGrams(double portionInGrams) {
        this.portionInGrams = portionInGrams;
    }

    public double getCarbs() {
        return this.carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return this.fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getProtein() {
        return this.protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCalories() {
        return this.calories;
    }

    public void setCalories(double calories) {
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
