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

    public String startMarathon(){

        String results = "";
        for (Specie s : list){
            double time;
            double distance = Math.random()*(80-20) + 20;
            results += s.toString() + "DISTANCIA RECORRIDA: " + String.format("%.1f", distance) + " km\nTIEMPO: ";

            if (s.getSpecie() == "Dog"){
                Dog aux = (Dog)s;
                time = aux.run(distance);
            } else if (s.getSpecie() == "Human"){
                Human aux = (Human)s;
                time = aux.run(distance);
            } else {
                Robot aux = (Robot)s;
                time = aux.run(distance);
            }

            if (time < 1){
                time = time * 60;
                results += String.format("%.0f", time) + " minutos\n\n";
            } else {
                results += String.format("%.0f", time) + " hora/s\n\n";
            }
        }

        return results;
    }
}
