package com.olehpodolin.service;

import com.olehpodolin.model.*;
import com.olehpodolin.repositories.CarbsRepository;
import com.olehpodolin.repositories.FatsRepository;
import com.olehpodolin.repositories.OtherProductsRepository;
import com.olehpodolin.repositories.ProteinRepository;

import java.util.HashSet;
import java.util.Random;

public class MealCalculator {

    private double carbsLimit;
    private double fatsLimit;
    private double proteinLimit;

    public MealCalculator(double carbsLimit, double fatsLimit, double proteinLimit) {
        this.carbsLimit = carbsLimit;
        this.fatsLimit = fatsLimit;
        this.proteinLimit = proteinLimit;
    }

    CarbsRepository carbsRepository = new CarbsRepository();
    FatsRepository fatsRepository = new FatsRepository();
    OtherProductsRepository otherProductsRepository = new OtherProductsRepository();
    ProteinRepository proteinRepository = new ProteinRepository();

    Sorter sorter = new Sorter(carbsRepository, fatsRepository, otherProductsRepository, proteinRepository);

    public HashSet<Product> evaluateMeal() {

        HashSet<Product> workingSet = getMainSetOfProducts(carbsLimit, fatsLimit, proteinLimit);

        HashSet<Product> readyMeal = completeMeal(workingSet);

        System.out.println(carbsLimit);
        System.out.println(fatsLimit);
        System.out.println(proteinLimit);

        return readyMeal;
    }

    public HashSet<Product> getMainSetOfProducts(double carbsLimit, double fatsLimit, double proteinLimit) {
        HashSet<Product> mainSet = new HashSet<>();
        Random random = new Random();

        double carbsRemaining = carbsLimit;
        double fatsRemaining = fatsLimit;
        double proteinRemainig = proteinLimit;

        mainSet.add(carbsRepository.get(random.nextInt(carbsRepository.size())));
        mainSet.add(fatsRepository.get(random.nextInt(fatsRepository.size())));
        mainSet.add(proteinRepository.get(random.nextInt(proteinRepository.size())));
        mainSet.add(otherProductsRepository.get(random.nextInt(otherProductsRepository.size())));

        for (Product  product : mainSet) {
            carbsRemaining = carbsRemaining - product.getCarbsInGrams();
            fatsRemaining = fatsRemaining - product.getFatsInGrams();
            proteinRemainig = proteinRemainig - product.getProteinInGrams();
        }

        this.carbsLimit = carbsLimit - carbsRemaining;
        this.fatsLimit = fatsLimit - fatsRemaining;
        this.proteinLimit = proteinLimit - proteinRemainig;

        return mainSet;
    }

    public HashSet<Product> completeMeal(HashSet<Product> mainSetOfProducts) {


        HashSet<Product> completedSet = new HashSet<>(mainSetOfProducts);
        return completedSet;
    }
}
