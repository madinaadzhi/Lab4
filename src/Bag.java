import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Item> items;
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public int getValue(){
        int sum = 0;
        for (Item item : items) {
            sum += item.getValue();
        }
        return sum;
    }

    public int getWeight(){
        int sum = 0;
        for (Item item : items) {
            sum += item.getWeight();
        }
        return sum;
    }
}
