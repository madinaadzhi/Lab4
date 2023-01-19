import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab5 {
    public static void main(String[] args) {
        InputParams inputParams = new InputParams(500, 100, 2, 30, 1,
                20, 100, 1, true,
                50, 100, 1000);

        List<Item> items = GenerationUtils.generateItems(inputParams.getCntItems(), inputParams.getMinValue(), inputParams.getMaxValue(),
                inputParams.getMinWeight(), inputParams.getMaxWeight());
        Population originPopulation = GenerationUtils.createPopulation(inputParams.getInitialPopulation(),
                inputParams.isUniqueItemsInPopulation(), inputParams.getCntItems());

        List<MutationResult> experimentResults = new ArrayList<>();

        for (CrossOver crossOver : CrossOver.values()) {
            for (Mutation mutation : Mutation.values()) {
//                for (Integer iteration : List.of(500, 1000, 2000, 5000)) {
                for (Integer iteration : List.of(1000)) {
                    inputParams.setMutationCnt(iteration);
                    Population population = new Population(originPopulation.getIndivids());
                    MutationResult mutationResult = GeneticAlgorithm.mutate(inputParams, items, population, crossOver, mutation);
                    experimentResults.add(mutationResult);
                }
            }
        }

        Collections.sort(experimentResults, Collections.reverseOrder());

        for (MutationResult result : experimentResults) {
            System.out.println(result);
//            if (result.getIterationCount() == 1000) {
//                System.out.println(result.getBags().stream().map(Bag::getValue).collect(Collectors.toList()));
//            }
        }
    }
}