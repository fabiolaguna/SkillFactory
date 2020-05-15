package net.skillfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringManagement {

    public static List<String> removeEvenLength(List<String> words){

        words = Optional.ofNullable(words).orElse(new ArrayList<>()); //Si es null creo una lista vacia
        return words.stream()
                .filter(word -> word.length()%2==1)
                .collect(Collectors.toList());
    }
}
