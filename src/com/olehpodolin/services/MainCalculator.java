package com.olehpodolin.services;

import com.olehpodolin.model.Product;
import com.olehpodolin.repositories.CarbsRepository;
import com.olehpodolin.repositories.FatsRepository;
import com.olehpodolin.repositories.OtherProductsRepository;
import com.olehpodolin.repositories.ProteinRepository;

import java.util.Random;

public class MainCalculator {

    private double overallCaloryLimit;
    private double caloriesForCarb;
    private double caloriesForFats;
    private double caloriesForProteins;

    Random random = new Random();

    CarbsRepository carbsRepository = new CarbsRepository();
    FatsRepository fatsRepository = new FatsRepository();
    OtherProductsRepository otherProductsRepository = new OtherProductsRepository();
    ProteinRepository proteinRepository = new ProteinRepository();

    public MainCalculator(double overallCaloryLimit) {
        this.overallCaloryLimit = overallCaloryLimit;
        this.caloriesForFats = overallCaloryLimit * 0.2 / 9;
        this.caloriesForProteins = overallCaloryLimit * 0.3 / 4;
        this.caloriesForCarb = overallCaloryLimit * 0.5 / 4;
    }

    Sorter sorter = new Sorter(carbsRepository, fatsRepository, otherProductsRepository, proteinRepository);

    public Product addRandomProducts(String productType) {

        Product returnProduct = new Product();

        switch (productType) {
            case "carbs":
                returnProduct = carbsRepository.get(random.nextInt(carbsRepository.size()));
                break;
            case "proteins":
                returnProduct = proteinRepository.get(random.nextInt(proteinRepository.size()));
                break;
            case "fats":
                returnProduct = fatsRepository.get(random.nextInt(fatsRepository.size()));
                break;
            case "other":
                returnProduct = otherProductsRepository.get(random.nextInt(otherProductsRepository.size()));
                break;
            default:
                System.err.println("Wrong product type getCarbProduct()");
        }
        return returnProduct;
    }

    public void calibrateLimits(Product product) {
        overallCaloryLimit -= product.getCalories();
        caloriesForCarb -= product.getCarbs();
        caloriesForProteins -= product.getProtein();
        caloriesForFats -= product.getFats();
        System.out.println("Calibrated Limits " + overallCaloryLimit);
        remainingCaloriesToMatch();
    }

    public String remainingCaloriesToMatch() {
        return "MainCalculator{" +
                "overallCaloryLimit=" + overallCaloryLimit +
                ", caloriesForCarb=" + caloriesForCarb +
                ", caloriesForFats=" + caloriesForFats +
                ", caloriesForProteins=" + caloriesForProteins +
                '}';
    }
}
