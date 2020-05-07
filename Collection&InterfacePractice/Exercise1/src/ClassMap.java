import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ClassMap<Integer, T> {

    private Map<Integer, T> map;

    public ClassMap(){
        map = new TreeMap<>();
    }

    public void add(Integer k, T t){
        map.put(k,t);
    }

    public T removeByKey(Integer k){
        return map.remove(k);
    }

    public boolean remove(Integer k, T t){
        return map.remove(k,t);
    }

    public T get(Integer k){
        return map.get(k);
    }

    public boolean keyExist(Integer k){
        return map.containsKey(k);
    }

    public boolean elementExist(T t){
        return map.containsValue(t);
    }

    public String printWithForEach(){

        String mapElements = "";
        for (Map.Entry<Integer,T> entry : map.entrySet()){
            mapElements += "Key = " + entry.getKey() + ", Value = " + entry.getValue() + "\n";
        }

        return mapElements;
    }

    public String printWithIterator(){

        String mapElements = "";
        Iterator<Map.Entry<Integer,T>> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<Integer,T> entry = entries.next();
            mapElements += "Key = " + entry.getKey() + ", Value = " + entry.getValue() + "\n";
        }

        return mapElements;
    }

}
