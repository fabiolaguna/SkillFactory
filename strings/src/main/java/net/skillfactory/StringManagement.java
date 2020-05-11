package net.skillfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StringManagement {

    private Map<Character,Integer> romanNumbers;

    public StringManagement(){
        romanNumbers = new HashMap<>();
    }

    public boolean palindromo(String word){

        String wordWithoutSpaces = word.replace(" ", "");

        StringBuilder stringBuilder = new StringBuilder(wordWithoutSpaces);
        stringBuilder = stringBuilder.reverse();

        if (wordWithoutSpaces.equalsIgnoreCase((stringBuilder.toString()))){
            return true;
        } else {
            return false;
        }
    }

    public int romanNumbersToInteger(String romanNumber){

        romanNumber.toUpperCase();
        StringBuilder sb = new StringBuilder(romanNumber);
        int result = 0;

        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        for (int i=0 ; i < sb.length() ; i++){

            char romanNumberChar = sb.charAt(i);
            if (i>0){

                if (romanNumbers.get(romanNumberChar) <= romanNumbers.get(sb.charAt(i-1))){
                    result += romanNumbers.get(romanNumberChar);
                } else {
                    result += romanNumbers.get(romanNumberChar) - (romanNumbers.get(sb.charAt(i-1)) * 2);
                }
            } else {
                result += romanNumbers.get(romanNumberChar);
            }
        }

        return result;
    }

    public String reorderWords(String words){

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

    public void printCharactersCount(String words){

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

        System.out.println("Digitos: " + numberCount + ". Letras: " + letterCount + ". Espacios: " + spaceCount + "\n");
    }
}
