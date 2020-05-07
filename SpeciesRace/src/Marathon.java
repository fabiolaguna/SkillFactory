import java.util.ArrayList;
import java.util.List;

public class Marathon {

    private List<ISprintable> list;

    public Marathon(){
        list = new ArrayList<>();
    }

    public void addRunner(ISprintable runner){
        list.add(runner);
    }

    public String startMarathon(){

        String results = "";
        for (ISprintable s : list){
            double time;
            double distance = Math.random()*(80-20) + 20;
            results += s.toString() + "DISTANCIA RECORRIDA: " + String.format("%.1f", distance) + " km\nTIEMPO: ";

            time = s.run(distance);

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
