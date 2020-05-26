package net.skillfactory;

import net.skillfactory.exception.ProductNotSupportedException;
import net.skillfactory.interfaces.AbstractFactory;
import net.skillfactory.model.Client;
import net.skillfactory.model.FactoryBlueLcd;
import net.skillfactory.model.FactoryYellowPlasma;
import net.skillfactory.model.Product;

public class App {

    public static void main( String[] args ) throws ProductNotSupportedException {

        AbstractFactory factory = getFactory("Blue Lcd");

        Client client = new Client(new Product(factory), "Ramon");
        System.out.println(client.toString());
    }

    public static AbstractFactory getFactory(String productType) throws ProductNotSupportedException {

        if(productType.equalsIgnoreCase("Blue Lcd")){
            return new FactoryBlueLcd();
        } else if(productType.equalsIgnoreCase("Yellow Plasma")){
            return new FactoryYellowPlasma();
        } else {
            throw new ProductNotSupportedException("The product " + productType + " is not supported");
        }
    }
}
