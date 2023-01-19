import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm {
    public static MutationResult mutate(InputParams in) {
        List<Item> items = GenerationUtils.generateItems(in.getCntItems(), in.getMinValue(), in.getMaxValue(), in.getMinWeight(), in.getMaxWeight());
        Population population = GenerationUtils.createPopulation(in.getInitialPopulation(), in.isUniqueItemsInPopulation(), in.getCntItems());
        return mutate(in, items, population, CrossOver.ONEPOINT, Mutation.BITFLIP);
    }

    public static MutationResult mutate(InputParams in, List<Item> items, Population population, CrossOver crossOver, Mutation mutation) {
        List<Bag> bags = new ArrayList<>();

        for (int i = 0; i < in.getMutationCnt(); i++) {
            Individ individ = defineFittestIdentity(items, population);
            crossOveringAndMutation(individ, population, in.getGensCntForCrossOvering(), in.getMutationProbability(),
                    in.getBagCapacity(), items, crossOver, mutation);
            individ = defineFittestIdentity(items, population);
            Bag bag = getBag(individ, items);
            bags.add(bag);
        }
        return new MutationResult(bags, items, mutation, crossOver, in.getMutationCnt());
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

    private static void crossOveringAndMutation(Individ fittestIdentity, Population population, int gensCntForCrossOvering, int mutationProbability, int bagCapacity, List<Item> items, CrossOver crossOver, Mutation mutation) {
        int size = population.getIndivids().size();
        int indexRandomIndivid;
        Individ randomIndivid;
        // selecting random individ
        while (true) {
            indexRandomIndivid = RandomUtils.getRandom().nextInt(size);
            randomIndivid = population.getIndivids().get(indexRandomIndivid);
            if (randomIndivid != fittestIdentity) {
                break;
            }
        }

        Individ childIndivid = new Individ(randomIndivid.getGens());

        switch (crossOver) {
            case ONEPOINT -> onePointCrossOvering(fittestIdentity, gensCntForCrossOvering, childIndivid);
            case UNIFORM -> uniformCrossOvering(fittestIdentity, size, childIndivid);
            case TWOPOINT -> twoPointCrossOvering(fittestIdentity, size, childIndivid);
        }

        if (needMutation(mutationProbability)) {
            switch (mutation) {
                case BITFLIP -> bitFlipMutation(size, childIndivid);
                case SWAP -> swapMutation(size, childIndivid);
            }
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

    private static void uniformCrossOvering(Individ fittestIdentity, int size, Individ childIndivid) {
        for (int i = 0; i < childIndivid.getGens().length; i++) {
            boolean randomParent = RandomUtils.getRandom().nextBoolean();
            if (randomParent) {
                childIndivid.getGens()[i] = fittestIdentity.getGens()[i];
            }
        }
    }

    private static void twoPointCrossOvering(Individ fittestIdentity, int size, Individ childIndivid) {
        int firstPoint = RandomUtils.getRandom().nextInt(size / 2);
        int secondPoint = RandomUtils.getRandom().nextInt((size - size / 2) + 1) + size / 2;
        if (firstPoint > secondPoint) {
            throw new IllegalStateException("generated points are wrong");
        }
        for (int i = firstPoint; i < secondPoint; i++) {
            childIndivid.getGens()[i] = fittestIdentity.getGens()[i];
        }
    }

    private static void onePointCrossOvering(Individ fittestIdentity, int gensCntForCrossOvering, Individ childIndivid) {
        for (int i = 0; i < childIndivid.getGens().length - gensCntForCrossOvering; i++) {
            childIndivid.getGens()[i] = fittestIdentity.getGens()[i];
        }
    }

    private static void swapMutation(int size, Individ childIndivid) {
        int indexRandomFirstGen = RandomUtils.getRandom().nextInt(size);
        int indexRandomSecondGen = RandomUtils.getRandom().nextInt(size);
        if (indexRandomFirstGen != indexRandomSecondGen) {
            boolean firstGen = childIndivid.getGens()[indexRandomFirstGen];
            boolean secondGen = childIndivid.getGens()[indexRandomSecondGen];
            childIndivid.getGens()[indexRandomFirstGen] = secondGen;
            childIndivid.getGens()[indexRandomSecondGen] = firstGen;
        }
    }

    private static void bitFlipMutation(int size, Individ childIndivid) {
        int indexRandomGen = RandomUtils.getRandom().nextInt(size);
        childIndivid.getGens()[indexRandomGen] = !childIndivid.getGens()[indexRandomGen];
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

}
