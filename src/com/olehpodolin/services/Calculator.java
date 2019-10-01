package com.olehpodolin.services;

import com.olehpodolin.model.*;

import java.util.HashSet;

public class Calculator {

    private LimitObject limitObject;

    public Calculator(LimitObject limitObject) {
        this.limitObject = limitObject;
    }

    public void calibrateLimits(HashSet<Product> products) {

        for(Product product : products) {
            limitObject.decreaseOverallCalories(product.getCalories());
            limitObject.decreaseCarbsCalories(product.getCarbs());
            limitObject.decreaseProteinCalories(product.getProtein());
            limitObject.decreaseFatsCalories(product.getFats());
        }
    }

    public void readLimits(LimitObject limitObject) {

    }

    public LimitObject getLimitObject() {
        return limitObject;
    }
}
