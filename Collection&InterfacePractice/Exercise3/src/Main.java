import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaaa");
        list.add("b");
        System.out.println(list);
        removeEvenLength(list);
        System.out.println(list);
    }

    public static void removeEvenLength(List<String> list){

        List<String> deletedStrings = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){

            if(list.get(i).length()%2 == 0){
                deletedStrings.add(list.get(i));
            }
        }

        for (String deleted : deletedStrings){
            list.remove(deleted);
        }
    }
}
