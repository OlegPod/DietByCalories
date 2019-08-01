package model;

import java.util.LinkedList;

public class Product  extends LinkedList<Product> {

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

}
