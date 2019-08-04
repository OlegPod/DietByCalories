package model;

public class Product {

    final String name;
    final float carbs;
    final float fats;
    final float protein;

    public Product(String name, float carbs, float fats, float protein) {
        this.name = name;
        this.carbs = carbs;
        this.fats = fats;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " name='" + name + '\'' +
                ", carbs=" + carbs +
                ", fats=" + fats +
                ", protein=" + protein +
                '}';
    }
}
