import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();
    public static Random getRandom(){
        return new Random(System.nanoTime());
    }
}
