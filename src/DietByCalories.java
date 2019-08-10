import com.olehpodolin.collector.Day;
import com.olehpodolin.repositories.CarbsRepository;
import com.olehpodolin.repositories.FatsRepository;
import com.olehpodolin.repositories.OtherProductsRepository;
import com.olehpodolin.repositories.ProteinRepository;
import com.olehpodolin.service.Sorter;

public class DietByCalories {

    public static void main(String[] args) {

        CarbsRepository carbsRepository = new CarbsRepository();
        FatsRepository fatsRepository = new FatsRepository();
        OtherProductsRepository otherProductsRepository = new OtherProductsRepository();
        ProteinRepository proteinRepository = new ProteinRepository();

        Sorter sorter = new Sorter(carbsRepository, fatsRepository, otherProductsRepository, proteinRepository);

        sorter.sort();

        carbsRepository.forEach(product -> System.out.println(product.toString()));
        fatsRepository.forEach(product -> System.out.println(product.toString()));
        otherProductsRepository.forEach(product -> System.out.println(product.toString()));
        proteinRepository.forEach(product -> System.out.println(product.toString()));

        Day day = new Day("Monday", 2000);

        System.out.println(day.getCaloriesNeeded());
        System.out.println("Carbs for the day " + day.getCarbsNeeded());
        System.out.println("Fats for the day " + day.getFatsNeeded());
        System.out.println("Protein for the day " + day.getProteinNeeded());
    }

}
