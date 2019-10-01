import com.olehpodolin.controllers.CalculatorController;
import com.olehpodolin.services.Calculator;
import com.olehpodolin.services.LimitObject;
import com.olehpodolin.services.Weigher;

public class DietByCalories {

    public static void main(String[] args) {

        Weigher weigher = new Weigher();

        LimitObject limitObject = new LimitObject(2000);

        Calculator calculator = new Calculator(limitObject);

        CalculatorController calculatorController = new CalculatorController(
                weigher, calculator);

        calculatorController.calibrateLimits(calculatorController.getProducts());

        System.out.println(calculatorController.getProducts());

        calculatorController.printRemainingLimits();
    }

}
