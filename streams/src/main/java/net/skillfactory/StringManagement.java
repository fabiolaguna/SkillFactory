package net.skillfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
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

    public static String cesarEncryption(String words){

        Optional.ofNullable(words).orElseThrow(NullStringException::new);
        StringBuilder sb = new StringBuilder();

        if (words.matches("[a-zA-Z]+")){

            words.chars()
                    .forEach(caracter -> sb.append(nextCharacter((char)caracter)));

            return sb.toString();
        } else {
            throw new InvalidStringToCesarEncryption();
        }
    }

    private static char nextCharacter(char c){

        if (c == 90){
            c = 64;
        } else if (c == 122){
            c = 96;
        }
        return (char) (c+1);
    }
}
