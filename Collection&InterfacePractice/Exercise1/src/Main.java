public class Main {

    public static void main(String[] args) {

        ClassList list = new ClassList();

        list.add("Perro");
        list.add("Gato");
        list.add("Silla");
        list.add("Mesa");

        //list.remove("Gato");
        list.removeByIndex(2);

        String word = list.get(1);
        //System.out.println(word);

        list.reverseOrder();
        //System.out.println(list.printWithIterator());

        ClassSet set = new ClassSet();

        set.add("Silla");
        set.add("Gato");
        set.add("Perro");
        set.add("Mesa");

        set.remove("Perro");
        String word2 = set.get("Silla");
        if (word2 != null){
            //System.out.println(word2);
        } else {
            //System.out.println("La palabra escrita no se encuentra en el set");
        }

        //System.out.println(set.printWithIterator());

        ClassMap<Integer, String> map = new ClassMap();

        map.add(4, "Mesa");
        map.add(1, "Perro");
        map.add(2, "1222");
        map.add(6, "Silla");
        map.add(3, "7676");

        if (map.remove(6, "Silla")){
            //System.out.println("Se ha eliminado correctamente");
        }

        String word3 = map.get(4);
        //System.out.println(word3);

        if (map.elementExist("Pero")){
            //System.out.println("El elemento se encuentra en el set");
        } else {
            //System.out.println("El elemento no se encuentra en el set");
        }

        if (map.keyExist(2)){
            System.out.println("La key es usada en el set");
        } else {
            System.out.println("Key no encontrada");
        }

        System.out.println(map.printWithIterator());

    }
}
