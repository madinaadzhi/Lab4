import java.util.ArrayList;
import java.util.Arrays;

public class GeneticAlgorithm {
    private Bag bag;
    private PossibleItems possibleItems;
    private Population population;

    public Bag doGeneticAlgorithm(Population population) {
        boolean[] childChromosome = crossoveringParentChromosome(population);
        System.out.println(Arrays.toString(childChromosome));

        boolean[] mutantChromosome = mutatingChildChromosome(childChromosome);
        System.out.println(Arrays.toString(mutantChromosome));

        Population newPopulation = createNewPopulation(population, mutantChromosome);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(newPopulation.getChromosomes()[i][j] + "  ");
            }
            System.out.println();
        }
        return null;
    }
//    public Bag doGeneticAlgorithm(Population population) {
//        boolean[] childChromosome = crossoveringParentChromosome(population);
//        System.out.println(Arrays.toString(childChromosome));
//
//        boolean[] mutantChromosome = mutatingChildChromosome(childChromosome);
//        System.out.println(Arrays.toString(mutantChromosome));
//
//        Population newPopulation = createNewPopulation(population, mutantChromosome);
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(newPopulation.getChromosomes()[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        return null;
//    }

    public boolean[] defineFittestChromosome(Population population) {
//        int sumValueMin = 0;
//        int sumValue = 0;
//        int sumWeightMin = 0;
//        int sumWeight = 0;
//        for (Item item : possibleItems.getItems()) {
//            for (int i = 0; i < population.getChromosomes().length; i++) {
//                for (int j = 0; j < population.getChromosomes().length; j++) {
//                    if (population.getChromosomes()[i][j]) {
//                        sumValueMin = sumValueMin + possibleItems.getItems().get(0).getValue();
//                        sumValue = sumValue + item.getValue();
//                        if (sumWeight < bag.getCapacity()) {
//                            sumWeightMin = sumWeightMin + possibleItems.getItems().get(0).getWeight();
//                            sumWeight = sumWeight + item.getWeight();
//                        }
//                    }
//                    if (sumValueMin < sumValue && sumWeightMin < sumWeight) {
//                        bag.setBag(population.getChromosomes()[i]);
//                    }
//                }
//            }
//        }
//        return bag.getBag();
        return new boolean[]{false, true, true, false, false, false};
    }

    public boolean[] crossoveringParentChromosome(Population population) {
//        Random random = new Random();
//        int indexRandomChromosome = random.nextInt(5);
//        parentChromosome = population.getChromosomes()[indexRandomChromosome];
        boolean[] parent1Chromosome = defineFittestChromosome(population);
        boolean[] parent2Chromosome = defineFittestChromosome(population);
        boolean[] child = new boolean[6];
        for (int i = 0; i < parent1Chromosome.length - 3; i++) {
            for (int j = 3; j < parent2Chromosome.length; j++) {
                child[i] = parent1Chromosome[i];
                child[j] = parent2Chromosome[j];
            }
        }
        return child;
    }

    public boolean[] mutatingChildChromosome(boolean[] childChromosome) {
//        Random random = new Random();
//        int indexRandomGen = random.nextInt(5);
        childChromosome[4] = !childChromosome[4];
        return childChromosome;
    }

    public Population createNewPopulation(Population population, boolean[] childChromosome) {
        Population newPopulation = new Population();
        newPopulation.getChromosomes()[0] = childChromosome;
        return newPopulation;
    }

}
