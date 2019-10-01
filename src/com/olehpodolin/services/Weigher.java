package com.olehpodolin.services;

import com.olehpodolin.model.*;
import com.olehpodolin.repositories.CarbsRepository;
import com.olehpodolin.repositories.FatsRepository;
import com.olehpodolin.repositories.OtherProductsRepository;
import com.olehpodolin.repositories.ProteinRepository;

import java.util.*;

public class Weigher {

    private CarbsRepository carbsRepository = new CarbsRepository();
    private FatsRepository fatsRepository = new FatsRepository();
    private OtherProductsRepository otherProductsRepository = new OtherProductsRepository();
    private ProteinRepository proteinRepository = new ProteinRepository();

    private Sorter sorter = new Sorter(carbsRepository, fatsRepository, otherProductsRepository, proteinRepository);

    private Random random = new Random();

    public Product addRandomProduct(String productType) {

        Product returnProduct = new Product();

        switch (productType) {
            case "carbs":
                returnProduct = carbsRepository.get(random.nextInt(carbsRepository.size()));
                System.out.println(returnProduct);
                break;
            case "proteins":
                returnProduct = proteinRepository.get(random.nextInt(proteinRepository.size()));
                System.out.println(returnProduct);
                break;
            case "fats":
                returnProduct = fatsRepository.get(random.nextInt(fatsRepository.size()));
                System.out.println(returnProduct);
                break;
            case "other":
                returnProduct = otherProductsRepository.get(random.nextInt(otherProductsRepository.size()));
                System.out.println(returnProduct);
                break;
            default:
                throw new RuntimeException("Wrong product type");
        }
        return returnProduct;
    }

    public HashSet<Product> fillWithProducts() {

        HashSet<Product> products  = new HashSet<>();

        products.add(addRandomProduct("carbs"));
        products.add(addRandomProduct("carbs"));
        products.add(addRandomProduct("proteins"));
        products.add(addRandomProduct("proteins"));
        products.add(addRandomProduct("fats"));
        products.add(addRandomProduct("other"));
        products.add(addRandomProduct("other"));
        products.add(addRandomProduct("other"));

        return products;
    }

}
