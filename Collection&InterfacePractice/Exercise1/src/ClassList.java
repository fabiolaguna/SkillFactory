import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClassList {

    private List<String> list;

    public ClassList(){
        list = new ArrayList<>();
    }

    public void add(String s){
        list.add(s);
    }

    public void remove(String s){
        list.remove(s);
    }

    public String removeByIndex(int index){
        return list.remove(index);
    }

    public String get(int index){
        return list.get(index);
    }

    public String printWithForEach() {

        String listElements = "";
        for (String s : list){
            listElements += s + "\n";
        }

        return listElements;
    }

    public String printWithIterator(){

        String listElements = "";
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            listElements += it.next() + "\n";
        }

        return listElements;
    }

    public void order(){
        Collections.sort(list);
    }

    public void reverseOrder(){
        Collections.sort(list, Collections.reverseOrder());
    }

}
