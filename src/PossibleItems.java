import java.util.ArrayList;
import java.util.List;

public class PossibleItems {
    private List<Item> items;

    public PossibleItems() {
        this.items = new ArrayList<>(6);
        items.add(new Item(5, 2));
        items.add(new Item(7, 3));
        items.add(new Item(8, 4));
        items.add(new Item(6, 3));
        items.add(new Item(4, 2));
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
