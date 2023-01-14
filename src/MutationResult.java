import java.util.List;

public class MutationResult {
    private List<Bag> bags;
    private List<Item> items;
    public MutationResult(List<Bag> bags, List<Item> items) {
        this.bags = bags;
        this.items = items;
    }

    public List<Bag> getBags() {
        return bags;
    }

    public List<Item> getItems() {
        return items;
    }
}
