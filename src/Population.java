import java.util.ArrayList;
import java.util.List;

public class Population {
    private List<Individ> individs;

    public Population() {
    }

    public Population(List<Individ> individs) {
        List<Individ> individList = new ArrayList<>();
        for (Individ individ : individs) {
            individList.add(new Individ(individ.getGens()));
        }
        this.individs = individList;
    }

    public List<Individ> getIndivids() {
        return individs;
    }

    public void setIndivids(List<Individ> individs) {
        this.individs = individs;
    }
}
