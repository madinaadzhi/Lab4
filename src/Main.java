import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GeneticAlgorithm algorithm = new GeneticAlgorithm();
        algorithm.doGeneticAlgorithm(new Population());
//        List<Item> itemsInBag = algorithm.doGeneticAlgorithm(new Population());
        int sum = sumNum(2, 2);

    }
    public static int sumNum(int a, int b) {
        return a + b;
    }
}
