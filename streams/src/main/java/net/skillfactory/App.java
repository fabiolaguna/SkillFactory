package net.skillfactory;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main( String[] args ) {

        List<String> wordsList;
        wordsList = StringManagement.removeEvenLength(Arrays.asList("Hola", "Al", "Toque", "Roque", "Al", "Pique", "Enrique"));
        wordsList.stream().forEach(word -> System.out.println(word));

        StringManagement.printCharactersCount("Soy Independiente, aunque no gano la libertadores desde 1985, sigo siendo el máximo campeón con 7 copas");

        
    }
}
