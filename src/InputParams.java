public class InputParams {
    private int bagCapacity;
    private int cntItems;
    private int minValue;
    private int maxValue;
    private int minWeight;
    private int maxWeight;
    private int initialPopulation;
    private int itemsCntInPopulation;
    private boolean uniqueItemsInPopulation;
    private int gensCntForCrossOvering;
    private int mutationProbability;
    private int gensCntForMutation;
    private int mutationCnt;
    public InputParams(int bagCapacity, int cntItems, int minValue, int maxValue, int minWeight, int maxWeight, int initialPopulation, int itemsCntInPopulation, boolean uniqueItemsInPopulation, int gensCntForCrossOvering, int mutationProbability, int gensCntForMutation, int mutationCnt) {
        this.bagCapacity = bagCapacity;
        this.cntItems = cntItems;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.initialPopulation = initialPopulation;
        this.itemsCntInPopulation = itemsCntInPopulation;
        this.uniqueItemsInPopulation = uniqueItemsInPopulation;
        this.gensCntForCrossOvering = gensCntForCrossOvering;
        this.mutationProbability = mutationProbability;
        this.gensCntForMutation = gensCntForMutation;
        this.mutationCnt = mutationCnt;
    }

    public int getBagCapacity() {
        return bagCapacity;
    }

    public int getCntItems() {
        return cntItems;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public int getInitialPopulation() {
        return initialPopulation;
    }

    public int getItemsCntInPopulation() {
        return itemsCntInPopulation;
    }

    public boolean isUniqueItemsInPopulation() {
        return uniqueItemsInPopulation;
    }

    public int getGensCntForCrossOvering() {
        return gensCntForCrossOvering;
    }

    public int getMutationProbability() {
        return mutationProbability;
    }

    public int getGensCntForMutation() {
        return gensCntForMutation;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMutationCnt() {
        return mutationCnt;
    }
}

