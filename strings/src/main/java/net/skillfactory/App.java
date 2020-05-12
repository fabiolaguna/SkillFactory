package net.skillfactory;

public class App {

    public static void main( String[] args ) {

        StringManagement sm = new StringManagement();

        if (sm.palindrome("Arriba la birra")){
            System.out.println("El string es palindromo\n");
        } else {
            System.out.println("El string no es palindromo\n");
        }

        String romanNumber = "VLXCIID";
        System.out.println("Numero romano: " + romanNumber + "  -  Decimal: " + sm.romanNumbersToInteger(romanNumber));

        String word = "Arriba la Birra";
        System.out.println(word);
        System.out.println("Reordenada: " + sm.reorderWords(word));

        sm.printCharactersCount("Boquita el unico grande con 18 titulos internacionales y 0 descensos");

        System.out.println(sm.cesarEncryption("abcde") + "\n");
    }
}
