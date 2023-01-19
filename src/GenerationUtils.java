import java.util.ArrayList;
import java.util.List;

public class GenerationUtils {
    public static List<Item> generateItems(int cntItems, int minValue, int maxValue, int minWeight, int maxWeight) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < cntItems; i++) {
            items.add(new Item(RandomUtils.getRandom().nextInt((maxValue - minValue) + 1) + minValue,
                    RandomUtils.getRandom().nextInt((maxWeight - minWeight) + 1) + minWeight));
        }
        return items;
    }

    public static Population createPopulation(int initialPopulation, boolean uniqueItemsInPopulation, int cntItems) {
        Population population = new Population();
        List<Individ> individs = new ArrayList<>();
        for (int i = 0; i < initialPopulation; i++) {
            Individ individ = new Individ(cntItems);
            if (uniqueItemsInPopulation) {
                individ.getGens()[i] = true;
            } else {
                individ.getGens()[RandomUtils.getRandom().nextInt(initialPopulation)] = true;
            }
            individs.add(individ);
        }
        population.setIndivids(individs);
        return population;
    }
}
