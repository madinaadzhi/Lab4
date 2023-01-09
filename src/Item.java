import java.util.Random;

public class Item {
    private int value;
    private int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //    public Item() {
//        Random random = new Random();
//        this.value = random.nextInt(20) + 2;
//        this.weight = random.nextInt(10) + 1;
//    }
}
