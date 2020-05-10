package net.skillfactory;

import java.util.HashMap;
import java.util.Map;

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
            char previousRomanNumberChar = 0;
            boolean previousRomanNumberCharExist = false;

            if (i>0) {
                previousRomanNumberCharExist = true;
                previousRomanNumberChar = sb.charAt(i-1);
            }

            if (previousRomanNumberCharExist){

                if (romanNumbers.get(romanNumberChar) <= romanNumbers.get(previousRomanNumberChar)){
                    result += romanNumbers.get(romanNumberChar);
                } else {
                    result += romanNumbers.get(romanNumberChar) - (romanNumbers.get(previousRomanNumberChar) * 2);
                }
            } else {
                result += romanNumbers.get(romanNumberChar);
            }
        }

        return result;
    }
}
