package com.olehpodolin.controllers;

import com.olehpodolin.model.Product;
import com.olehpodolin.services.Calculator;
import com.olehpodolin.services.Weigher;

import java.util.HashSet;

public class CalculatorController {

    private Weigher weigher;

    private Calculator calculator;

    public CalculatorController(Weigher weigher, Calculator calculator) {
        this.weigher = weigher;
        this.calculator = calculator;
    }

    private HashSet<Product> products = new HashSet<>();

    public HashSet<Product> getProducts() {
        products = weigher.fillWithProducts();

        return products;
    }

    public void calibrateLimits(HashSet<Product> products) {
        calculator.calibrateLimits(products);
    }

    public void printRemainingLimits() {
        System.out.println(calculator.getLimitObject());
    }
}
