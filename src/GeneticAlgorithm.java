import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm {
    public static MutationResult mutate(InputParams in) {
        List<Bag> bags = new ArrayList<>();
        List<Item> items = generateItems(in.getCntItems(), in.getMinValue(), in.getMaxValue(),
                in.getMinWeight(), in.getMaxWeight());
        Population population = createPopulation(in.getInitialPopulation(),
                in.isUniqueItemsInPopulation(), in.getCntItems());
        for (int i = 0; i < in.getMutationCnt(); i++) {
//            System.out.println("iteration " + i);
            Individ individ = defineFittestIdentity(items, population);
            crossOveringAndMutation(individ, population, in.getGensCntForCrossOvering(), in.getMutationProbability(), in.getBagCapacity(), items);
            individ = defineFittestIdentity(items, population);
            Bag bag = getBag(individ, items);
            bags.add(bag);
        }
        return new MutationResult(bags, items);
    }

    private static Bag getBag(Individ individ, List<Item> items) {
        Bag bag = new Bag();
        List<Item> bagItems = new ArrayList<>();
        for (int i = 0; i < individ.getGens().length; i++) {
            if (individ.getGens()[i]) {
                bagItems.add(items.get(i));
            }
        }
        bag.setItems(bagItems);
        return bag;
    }

    private static void crossOveringAndMutation(Individ fittestIdentity, Population population, int gensCntForCrossOvering, int mutationProbability, int bagCapacity, List<Item> items) {
        int size = population.getIndivids().size();
        int indexRandomIndivid;
        Individ randomIndivid;
        // selecting random individ
        while (true) {
            indexRandomIndivid = RandomUtils.getRandom().nextInt(size);
            randomIndivid = population.getIndivids().get(indexRandomIndivid);
            if (!randomIndivid.equals(fittestIdentity)) {
                break;
            }
        }

//        System.out.println("Random individ for crossOvering: " + indexRandomIndivid);
        // cross-overing
        Individ childIndivid = new Individ(randomIndivid.getGens());
        for (int i = 0; i < childIndivid.getGens().length - gensCntForCrossOvering; i++) {
            childIndivid.getGens()[i] = fittestIdentity.getGens()[i];
        }

        // mutation
        if (needMutation(mutationProbability)) {
            int indexRandomGen = RandomUtils.getRandom().nextInt(size);
            childIndivid.getGens()[indexRandomGen] = !childIndivid.getGens()[indexRandomGen];
        }

        // replace random individ by mutated one
        int sum = 0;
        for (int i = 0; i < childIndivid.getGens().length; i++) {
            if (childIndivid.getGens()[i]) {
                sum += items.get(i).getWeight();
            }
        }
        if (sum <= bagCapacity) {
            population.getIndivids().set(indexRandomIndivid, childIndivid);
        }
    }

    private static boolean needMutation(int mutationProbability) {
        return RandomUtils.getRandom().nextInt(100) < mutationProbability;
    }

    private static Individ defineFittestIdentity(List<Item> items, Population population) {
        int maxValue = 0;
        Individ individWithMaxValue = null;
        for (Individ individ : population.getIndivids()) {
            int value = getValue(individ, items);
            if (value > maxValue) {
                maxValue = value;
                individWithMaxValue = individ;
            }
        }
        return individWithMaxValue;
    }

    private static int getValue(Individ individ, List<Item> items) {
        int sumGen = 0;
        boolean[] gens = individ.getGens();
        for (int i = 0; i < gens.length; i++) {
            if (gens[i]) {
                sumGen = sumGen + items.get(i).getValue();
            }
        }
        return sumGen;
    }

    private static Population createPopulation(int initialPopulation, boolean uniqueItemsInPopulation, int cntItems) {
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

    private static List<Item> generateItems(int cntItems, int minValue, int maxValue, int minWeight, int maxWeight) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < cntItems; i++) {
            items.add(new Item(RandomUtils.getRandom().nextInt((maxValue - minValue) + 1) + minValue,
                    RandomUtils.getRandom().nextInt((maxWeight - minWeight) + 1) + minWeight));
        }
        return items;
    }
}
