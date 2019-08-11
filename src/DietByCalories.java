import com.olehpodolin.service.MealCalculator;

public class DietByCalories {

    public static void main(String[] args) {

        MealCalculator mealCalculator = new MealCalculator(120, 20, 50);

            System.out.println(mealCalculator.evaluateMeal());
    }

}
