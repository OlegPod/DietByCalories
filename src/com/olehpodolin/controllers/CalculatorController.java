package com.olehpodolin.controllers;

import com.olehpodolin.model.Product;
import com.olehpodolin.services.MainCalculator;

import java.util.HashSet;
import java.util.stream.Collectors;

public class CalculatorController {

    private HashSet<Product> productHashSet = new HashSet<>();

    private MainCalculator mainCalculator = new MainCalculator(2000);

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

        return products;
    }

    public void printRemainingCalories() {
        System.out.println(mainCalculator.remainingCaloriesToMatch());
    }

    public HashSet<Product> straighenMacronutrients(HashSet<Product> productHashSet) {

        HashSet<Product> returnSet = new HashSet<>();

        returnSet.addAll(mainCalculator.straightenCarbsType(productHashSet));
        returnSet.addAll(mainCalculator.straightenProteinType(productHashSet));
        returnSet.addAll(mainCalculator.straightenFatsType(productHashSet));
        returnSet.addAll(mainCalculator.straightenOtherType(productHashSet));

        return returnSet;
    }
}
