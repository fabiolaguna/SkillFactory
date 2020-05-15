package net.skillfactory;

public class App {

    public static void main( String[] args ) {

        if (StringManagement.palindrome("Arriba la birra")){
            System.out.println("El string es palindromo\n");
        } else {
            System.out.println("El string no es palindromo\n");
        }

        String romanNumber = "VLXCZID";
        System.out.println("Numero romano: " + romanNumber + "  -  Decimal: " + StringManagement.romanNumbersToInteger(romanNumber));

        String word = "Arriba la Birra";
        System.out.println(word);
        System.out.println("Reordenada: " + StringManagement.reorderWords(word));

        StringManagement.printCharactersCount("Boquita el unico grande con 18 titulos internacionales y 0 descensos");

        try {
            System.out.println(StringManagement.cesarEncryption("abc,de") + "\n");
        } catch (InvalidStringToCesarEncryption invalidStringToCesarEncryption) {
            invalidStringToCesarEncryption.printStackTrace();
        }

        System.out.println(StringManagement.verifyString("RegEx101.com"));
    }
}
