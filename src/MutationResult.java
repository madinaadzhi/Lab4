import java.util.List;

public class MutationResult implements Comparable<MutationResult> {
    private List<Bag> bags;
    private List<Item> items;
    private Mutation mutation;
    private CrossOver crossOver;
    private int iterationCount;

    public MutationResult(List<Bag> bags, List<Item> items, Mutation mutation, CrossOver crossOver, int iterationCount) {
        this.bags = bags;
        this.items = items;
        this.mutation = mutation;
        this.crossOver = crossOver;
        this.iterationCount = iterationCount;
    }

    public List<Bag> getBags() {
        return bags;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getMaxValue() {
        return bags.get(bags.size() - 1).getValue();
    }

    @Override
    public String toString() {
        return "MutationResult {" +
                "mutation = " + mutation +
                ", crossOver = " + crossOver +
                ", iterationCount = " + iterationCount +
                ", solution = " + getMaxValue() + '}';
    }

    @Override
    public int compareTo(MutationResult o) {
        if (this.getMaxValue() < o.getMaxValue()) {
            return -1;
        } else if (this.getMaxValue() > o.getMaxValue()) {
            return 1;
        }
        return 0;
    }
}
