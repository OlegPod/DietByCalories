package collector;

import model.Product;

import java.util.HashSet;
import java.util.LinkedList;

public class Day {

    private String name;

    private double caloriesNeeded;
    private double fatsNeeded;
    private double proteinNeeded;
    private double carbsNeeded;

    public Day(String name, double caloriesNeeded) {
        this.caloriesNeeded = caloriesNeeded;
        // Fats/Protein/Carbs ratio for the day 20%/30%/50%
        // divided by 9/4/4 calory corresponding for one gram of Fats/Protein/Carbs
        this.fatsNeeded = caloriesNeeded * 0.2 / 9;
        this.proteinNeeded = caloriesNeeded * 0.3 / 4;
        this.carbsNeeded = caloriesNeeded * 0.5 / 4;
    }

    private LinkedList<Product> setOfProducts;

    private HashSet<Product> firstMeal;
    private HashSet<Product> secondMeal;
    private HashSet<Product> thirdMeal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCaloriesNeeded() {
        return caloriesNeeded;
    }

    public void setCaloriesNeeded(double caloriesNeeded) {
        this.caloriesNeeded = caloriesNeeded;
    }

    public double getFatsNeeded() {
        return fatsNeeded;
    }

    public double getProteinNeeded() {
        return proteinNeeded;
    }

    public double getCarbsNeeded() {
        return carbsNeeded;
    }

    public LinkedList<Product> getSetOfProducts() {
        return setOfProducts;
    }

    public HashSet<Product> getFirstMeal() {
        return firstMeal;
    }

    public HashSet<Product> getSecondMeal() {
        return secondMeal;
    }

    public HashSet<Product> getThirdMeal() {
        return thirdMeal;
    }
}
