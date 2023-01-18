import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputParams inputParams = new InputParams(250, 100, 2, 20, 1,
                10, 100, 1, true,
                50, 5, 1000);

        MutationResult mutationResult = GeneticAlgorithm.mutate(inputParams);
        List<Bag> bags = mutationResult.getBags();

        System.out.println("Items: ");
        for (Item item : mutationResult.getItems()) {
            System.out.println(item);
        }

        System.out.println();
        for (int i = 1; i <= bags.size(); i++) {
            Bag bag = bags.get(i - 1);
            if (i % 20 == 0) {
                System.out.println("Iteration: " + i + ", Solution: " + bag.getValue());
            }
        }
    }
}
