package net.skillfactory;

public class StringManagement {

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
}
