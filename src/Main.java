import java.util.List;

public class Main {
    public static void main(String[] args) {

        // input params begin
        InputParams inputParams = new InputParams(250, 100, 2, 20, 1,
                10, 100, 1, true,
                50, 5, 1, 1000);

        List<Bag> bags = GeneticAlgorithm.mutate(inputParams);

        for (int i = 0; i < bags.size(); i++) {
            Bag bag = bags.get(i);
            if (i % 19 == 0) {
                System.out.println(i + "," + bag.getValue());
            }
        }

    }
}
