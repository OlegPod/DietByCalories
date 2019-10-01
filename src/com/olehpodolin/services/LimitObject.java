package com.olehpodolin.services;

public class LimitObject {

    private double overallCaloryLimit;
    private double caloriesForCarbs;
    private double caloriesForFats;
    private double caloriesForProteins;

    public LimitObject(double overallCaloryLimit) {
        this.overallCaloryLimit = overallCaloryLimit;
        this.caloriesForFats = overallCaloryLimit * 0.2;
        this.caloriesForProteins = overallCaloryLimit * 0.3;
        this.caloriesForCarbs = overallCaloryLimit * 0.5;
    }

    public void decreaseOverallCalories(double overall) {
        this.overallCaloryLimit -= overall;
    }

    public void decreaseCarbsCalories(double caloriesForCarbs) {
        this.caloriesForCarbs -= caloriesForCarbs;
    }

    public void decreaseProteinCalories(double caloriesForProteins) {
        this.caloriesForProteins -= caloriesForProteins;
    }

    public void decreaseFatsCalories(double caloriesForFats) {
        this.caloriesForFats -= caloriesForFats;
    }

    public double getCaloriesForCarbs() {
        return caloriesForCarbs;
    }

    public double getCaloriesForFats() {
        return caloriesForFats;
    }

    public double getCaloriesForProteins() {
        return caloriesForProteins;
    }

    @Override
    public String toString() {
        return "LimitObject{" +
                "overallCaloryLimit=" + this.overallCaloryLimit +
                ", caloriesForCarbs=" + this.caloriesForCarbs +
                ", caloriesForFats=" + this.caloriesForFats +
                ", caloriesForProteins=" + this.caloriesForProteins +
                '}';
    }
}
