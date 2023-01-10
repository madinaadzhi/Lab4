import java.util.List;

public class Main {
    public static void main(String[] args) {

        // input params begin
        InputParams inputParams = new InputParams(250, 100, 2, 20, 1,
                10, 100, 1, true,
                5, 100, 1000);

        MutationResult mutationResult = GeneticAlgorithm.mutate(inputParams);
        List<Bag> bags = mutationResult.getBags();

        System.out.println("Ítems: ");
        for (Item item : mutationResult.getItems()) {
            System.out.println(item);
        }

        for (int i = 1; i <= bags.size(); i++) {
            Bag bag = bags.get(i-1);
            if (i % 20 == 0) {
                System.out.println(i + "," + bag.getValue() );
            }
        }

    }
}
