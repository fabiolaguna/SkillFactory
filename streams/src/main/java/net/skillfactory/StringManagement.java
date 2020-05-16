package net.skillfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StringManagement {

    public static List<String> removeEvenLength(List<String> words){

        words = Optional.ofNullable(words).orElse(new ArrayList<>()); //Si es null creo una lista vacia
        return words.stream()
                .filter(word -> word.length()%2==1)
                .collect(Collectors.toList());
    }

    public static void printCharactersCount(String words){

        Optional.ofNullable(words).orElseThrow(NullStringException::new);
        Long spaceCount;
        Long numberCount;
        Long letterCount;

        numberCount = words.chars()
                .filter(caracter -> Character.isDigit(caracter))
                .count();
        letterCount = words.chars()
                .filter(caracter -> Character.isLetter(caracter))
                .count();
        spaceCount = words.chars()
                .filter(caracter -> Character.isWhitespace(caracter))
                .count();

        System.out.println(String.format("Digitos: %d. Letras: %d. Espacios: %d",numberCount,letterCount,spaceCount));
    }
}
