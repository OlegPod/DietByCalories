package com.olehpodolin.services;

import com.olehpodolin.model.*;
import com.olehpodolin.repositories.CarbsRepository;
import com.olehpodolin.repositories.FatsRepository;
import com.olehpodolin.repositories.OtherProductsRepository;
import com.olehpodolin.repositories.ProteinRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        this.caloriesForFats = overallCaloryLimit * 0.2;
        this.caloriesForProteins = overallCaloryLimit * 0.3;
        this.caloriesForCarb = overallCaloryLimit * 0.5;
    }

    Sorter sorter = new Sorter(carbsRepository, fatsRepository, otherProductsRepository, proteinRepository);

    public Product addRandomProducts(String productType) {

        Product returnProduct = new Product();

        switch (productType) {
            case "carbs":
                returnProduct = carbsRepository.get(random.nextInt(carbsRepository.size()));
                System.out.println(returnProduct);
                calibrateLimits(returnProduct);
                break;
            case "proteins":
                returnProduct = proteinRepository.get(random.nextInt(proteinRepository.size()));
                System.out.println(returnProduct);
                calibrateLimits(returnProduct);
                break;
            case "fats":
                returnProduct = fatsRepository.get(random.nextInt(fatsRepository.size()));
                System.out.println(returnProduct);
                calibrateLimits(returnProduct);
                break;
            case "other":
                returnProduct = otherProductsRepository.get(random.nextInt(otherProductsRepository.size()));
                System.out.println(returnProduct);
                calibrateLimits(returnProduct);
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
        System.out.println("Calibrated Limits " + overallCaloryLimit + " carbs " + caloriesForCarb + " fats " + caloriesForFats
                                        + " proteins " + caloriesForProteins);
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

    public Collection<? extends Product> straightenCarbsType(HashSet<Product> productHashSet) {

        List<Product> carbsProducts = productHashSet.stream()
                .filter(product -> product instanceof RichInCarbsProduct)
                .collect(Collectors.toList());

        System.out.println("filter " + carbsProducts);
        return carbsProducts;
    }

    public Collection<? extends Product> straightenProteinType(HashSet<Product> productHashSet) {

        List<Product> proteinProducts = productHashSet.stream()
                .filter(product -> product instanceof RichInProteinProduct)
                .collect(Collectors.toList());

        System.out.println("filter " + proteinProducts);
        return proteinProducts;
    }

    public Collection<? extends Product> straightenFatsType(HashSet<Product> productHashSet) {

        List<Product> fatsProducts = productHashSet.stream()
                .filter(product -> product instanceof RichInFatsProduct)
                .collect(Collectors.toList());

        System.out.println("filter " + fatsProducts);
        return fatsProducts;
    }

    public Collection<? extends Product> straightenOtherType(HashSet<Product> productHashSet) {

        List<Product> otherProducts = productHashSet.stream()
                .filter(product -> product instanceof OtherProducts)
                .collect(Collectors.toList());

        System.out.println("filter " + otherProducts);
        return otherProducts;
    }
}
