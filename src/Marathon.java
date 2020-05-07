import java.util.ArrayList;
import java.util.List;

public class Marathon {

    private List<Specie> list;

    public Marathon(){
        list = new ArrayList<>();
    }

    public void addRunner(Specie runner){
        list.add(runner);
    }

    public boolean removeRunner(Specie runner){
        return list.remove(runner);
    }

    public List<Specie> getList() {
        return list;
    }
}
