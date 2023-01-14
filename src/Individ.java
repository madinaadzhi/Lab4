import java.util.Arrays;

public class Individ {
    private boolean[] gens;

    public Individ(int size) {
        this.gens = new boolean[size];

    }

    public Individ(boolean[] gens) {
        this.gens = new boolean[gens.length];
        for (int i = 0; i < gens.length; i++) {
            this.gens[i] = gens[i];
        }

    }

    public boolean[] getGens() {
        return gens;
    }

    public void setGens(boolean[] gens) {
        this.gens = gens;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Individ)) {
            return false;
        }
        Individ individ = (Individ) obj;
        return Arrays.equals(this.getGens(), individ.getGens());

    }
}
