package net.skillfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;

public class StringManagement {

    public static boolean palindrome(String word){

        String wordWithoutSpaces = word.replace(" ", "");

        StringBuilder stringBuilder = new StringBuilder(wordWithoutSpaces);
        stringBuilder = stringBuilder.reverse();

        return wordWithoutSpaces.equalsIgnoreCase((stringBuilder.toString()));
    }

    public static int romanNumbersToInteger(String romanNumber){

        romanNumber.toUpperCase();
        StringBuilder sb = new StringBuilder(romanNumber);
        int result = 0;

        Map<Character,Integer> romanNumbers = new HashMap<>();;

        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        for (int i=0 ; i < sb.length() ; i++){

            Integer romanNumberDecimal = convertRomanNumberToDecimal(romanNumbers, sb.charAt(i));
            if (i>0){

                if (romanNumberDecimal <= romanNumbers.get(sb.charAt(i-1))){
                    result += romanNumberDecimal;
                } else {
                    result += romanNumberDecimal - (romanNumbers.get(sb.charAt(i-1)) * 2);
                }
            } else {
                result += romanNumberDecimal;
            }
        }

        return result;
    }

    private static Integer convertRomanNumberToDecimal(Map<Character,Integer> romanNumbers, Character romanNumber) throws IncorrectRomanNumberException {

        return Optional.ofNullable(romanNumber)
                .filter(number -> romanNumbers.containsKey(romanNumber))
                .map(number -> romanNumbers.get(number))
                .orElseThrow(IncorrectRomanNumberException::new);
    }

    public static String reorderWords(String words){

        StringBuilder sb = new StringBuilder(words);
        String reorderedWord = "";
        int endSubstring = sb.length();
        int i = sb.length() - 1;

        while (i>=0){

            if (sb.charAt(i) == ' ') {
                reorderedWord += sb.substring(i+1, endSubstring) + " ";
                endSubstring = i;
            } else if (i==0){
                reorderedWord += sb.substring(i, endSubstring);
            }

            i--;
        }

        return reorderedWord;
    }

    public static void printCharactersCount(String words){

        StringBuilder sb = new StringBuilder(words);
        int spaceCount = 0;
        int numberCount = 0;
        int letterCount = 0;

        for (int i=0 ; i<sb.length() ; i++){

            if (Character.isWhitespace(sb.charAt(i))){
                spaceCount++;
            }
            if (Character.isLetter(sb.charAt(i))){
                letterCount++;
            }
            if (Character.isDigit(sb.charAt(i))){
                numberCount++;
            }
        }

        System.out.println(String.format("Digitos: %s. Letras: %s. Espacios: %s",numberCount,letterCount,spaceCount));
    }

    public static String cesarEncryption(String word) throws InvalidStringToCesarEncryption {

        if (word.matches("[a-zA-Z]+")){
            String encryption = "";
            for (int i=0 ; i < word.length() ; i++){

                int nextAscii = (int) word.charAt(i) + 1;

                if (nextAscii == 123){
                    nextAscii = 97;
                }
                if (nextAscii == 91){
                    nextAscii = 65;
                }

                encryption += (char) nextAscii;
            }
            return encryption;
        } else {
            throw new InvalidStringToCesarEncryption();
        }
    }

    public static boolean verifyString(String word){

        if (word.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,30}$")){
            if (word.matches("[a-zA-Z0-9_]+")){
                if (Character.isDigit(word.charAt(0)) || Character.isLetter(word.charAt(0))) {
                    return true;
                }
            }
        }
        return false;
    }
}
