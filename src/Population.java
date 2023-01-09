import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Population {
    private boolean[][] chromosomes;

    public Population() {
        this.chromosomes = new boolean[][]{{true, false, false, false, false, true},
                {true, false, false, false, true, true},
                {false, false, false, true, true, true},
                {false, true, true, false, false, false}};
    }

    public boolean[][] getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(boolean[][] chromosomes) {
        this.chromosomes = chromosomes;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(chromosomes);
    }
}
