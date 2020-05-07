import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClassSet {

    private Set<String> set;

    public ClassSet(){
        set = new HashSet<>();
    }

    public void add(String s){
        set.add(s);
    }

    public void remove(String s){
        set.remove(s);
    }

    public String get(String s){

        if (set.contains(s)){
            return s;
        } else {
            return null;
        }
    }

    public String printWithForEach() {

        String setElements = "";
        for (String s : set){
            setElements += s + "\n";
        }

        return setElements;
    }

    public String printWithIterator(){

        String setElements = "";
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            setElements += it.next() + "\n";
        }

        return setElements;
    }

}
