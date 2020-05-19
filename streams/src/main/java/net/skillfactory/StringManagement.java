package net.skillfactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManagement {

    public static List<String> removeEvenLength(List<String> words){

        return Optional.ofNullable(words)
                .orElse(Collections.emptyList()) //Si es null creo una lista vacia
                .stream()
                .filter(word -> word.length() % 2 == 1)
                .collect(Collectors.toList());
    }

    public static void printCharactersCount(String words){

        Optional.ofNullable(words).orElseThrow(NullStringException::new);

        Map<String, Long> characters = words.chars()
                .mapToObj(chr -> (char)chr)
                .map(CharacterType::getType)
                .filter(type -> type != CharacterType.NotInteresting)
                .collect(Collectors.groupingBy(CharacterType::getName, Collectors.counting()));

        System.out.println(String.format("Digitos: %d. Letras: %d. Espacios: %d", characters.get("Digit"),
                characters.get("Letter"), characters.get("Whitespace")));
    }

    private enum CharacterType {
        Digit, Whitespace, Letter, NotInteresting;

        private static CharacterType getType(char character){

            if (Character.isDigit(character)){
                return Digit;
            }
            if (Character.isLetter(character)){
                return Letter;
            }
            if(Character.isWhitespace(character)){
                return Whitespace;
            }
            return NotInteresting;
        }

        private static String getName(CharacterType ct) {
            return ct.toString();
        }
    }

    public static String cesarEncryption(String words){

        Optional.ofNullable(words).orElseThrow(NullStringException::new);

        Optional.of(words)
                .filter(word -> word.matches("[a-zA-Z]+"))
                .orElseThrow(() -> new InvalidString("The specified string cannot be encrypted"));

        return words.chars()
                .mapToObj(character -> Character.toString(nextCharacter((char) character)))
                .collect(Collectors.joining());
    }

    private static char nextCharacter(char c){

        if (c == 90){
            c = 64;
        } else if (c == 122){
            c = 96;
        }
        return (char) (c+1);
    }

    public static String reorderWords(String words){

        Optional.ofNullable(words).orElseThrow(NullStringException::new);

        StringBuilder sb = new StringBuilder(words);
        StringBuilder sbFinal = new StringBuilder();

        sbFinal.append(Stream.of(sb.reverse().toString().split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" ")));

        return sbFinal.toString();
    }
}
