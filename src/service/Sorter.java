package service;

import model.OtherProducts;
import model.RichInCarbsProduct;
import model.RichInFatsProduct;
import model.RichInProteinProduct;
import repositories.CarbsRepository;
import repositories.FatsRepository;
import repositories.OtherProductsRepository;
import repositories.ProteinRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sorter {

    private CarbsRepository carbsRepository;
    private FatsRepository fatsRepository;
    private OtherProductsRepository otherProductsRepository;
    private ProteinRepository proteinRepository;

    public Sorter(CarbsRepository carbsRepository, FatsRepository fatsRepository,
                  OtherProductsRepository otherProductsRepository, ProteinRepository proteinRepository) {
        this.carbsRepository = carbsRepository;
        this.fatsRepository = fatsRepository;
        this.otherProductsRepository = otherProductsRepository;
        this.proteinRepository = proteinRepository;
    }

    public void sort() {
        Matcher nameMatcher = Pattern.compile("([A-Z][a-z]+\\s*)+").matcher("");
        Matcher nutrientMatcher = Pattern.compile("\\d+\\.?\\d+").matcher("");
        String productName = null;
        float carbsAmount = 0;
        float fatsAmount = 0;
        float proteinAmount = 0;
        int count = 0;

        for (String line : Reader.read("src//Products.txt")) {
            nameMatcher.reset(line);
            nutrientMatcher.reset(line);
            while (nameMatcher.find()) {
                productName = nameMatcher.group();
            }

            while (nutrientMatcher.find()) {
                count++;
                switch (count) {
                    case 1:
                        carbsAmount = Float.parseFloat(nutrientMatcher.group());
                    case 2:
                        fatsAmount = Float.parseFloat(nutrientMatcher.group());
                    case 3:
                        proteinAmount = Float.parseFloat(nutrientMatcher.group());
                    default:
                        break;
                }

                if (count == 3) {
                    count = 0;
                    if (carbsAmount > 80)
                        carbsRepository.add(new RichInCarbsProduct(productName, carbsAmount, fatsAmount, proteinAmount));
                    else if (fatsAmount > 80)
                        fatsRepository.add(new RichInFatsProduct(productName, carbsAmount, fatsAmount, proteinAmount));
                    else if (proteinAmount > 80)
                        proteinRepository.add(new RichInProteinProduct(productName, carbsAmount, fatsAmount, proteinAmount));
                    else
                        otherProductsRepository.add(new OtherProducts(productName, carbsAmount, fatsAmount, proteinAmount));
                }
            }
        }
    }
}
