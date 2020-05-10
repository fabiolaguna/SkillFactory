package net.skillfactory;

public class App {

    public static void main( String[] args ) {

        StringManagement sm = new StringManagement();

        if (sm.palindromo("Arriba la birra")){
            System.out.println("El string es palindromo\n");
        } else {
            System.out.println("El string no es palindromo\n");
        }
    }
}
