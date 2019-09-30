import com.olehpodolin.controllers.CalculatorController;
import com.olehpodolin.model.Product;

import java.util.HashSet;

public class DietByCalories {

    public static void main(String[] args) {

        CalculatorController calculatorController = new CalculatorController();

        HashSet<Product> productHashSet = new HashSet<>(calculatorController.fillWithProducts());

        calculatorController.printRemainingCalories();

        calculatorController.straightenMacronutrients(productHashSet);

        calculatorController.printRemainingCalories();
    }

}
