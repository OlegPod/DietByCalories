package com.olehpodolin.controllers;

import com.olehpodolin.model.Product;
import com.olehpodolin.services.MainCalculator;

import java.util.HashSet;

public class CalculatorController {

    private HashSet<Product> productHashSet = new HashSet<>();

    MainCalculator mainCalculator = new MainCalculator(2000);

    public HashSet<Product> fillWithProducts() {

        HashSet<Product> products  = new HashSet<>();

        products.add(mainCalculator.addRandomProducts("carbs"));
        products.add(mainCalculator.addRandomProducts("carbs"));
        products.add(mainCalculator.addRandomProducts("proteins"));
        products.add(mainCalculator.addRandomProducts("proteins"));
        products.add(mainCalculator.addRandomProducts("fats"));
        products.add(mainCalculator.addRandomProducts("other"));
        products.add(mainCalculator.addRandomProducts("other"));
        products.add(mainCalculator.addRandomProducts("other"));

        System.out.println(mainCalculator.remainingCaloriesToMatch());
        System.out.println(products);

        return products;
    }
}
