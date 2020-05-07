import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("123");
        list.add("C");
        System.out.println(list);
        removeEvenLength(list);
        System.out.println(list);
    }

    public static void removeEvenLength(ArrayList<String> list){

        for (int i = 0; i < list.size(); i++){

            if(list.get(i).length()%2 == 0){
                list.remove(i);
            }
        }
    }
}
