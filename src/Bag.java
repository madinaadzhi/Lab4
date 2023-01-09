import java.util.ArrayList;
import java.util.List;

public class Bag {
    private int capacity;
    private boolean[] bag;

    public Bag() {
        this.capacity = 8;
        this.bag = new boolean[6];
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean[] getBag() {
        return bag;
    }

    public void setBag(boolean[] bag) {
        this.bag = bag;
    }
}
