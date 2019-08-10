import repositories.CarbsRepository;
import repositories.FatsRepository;
import repositories.OtherProductsRepository;
import repositories.ProteinRepository;
import service.Sorter;

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
    }

}
