package net.skillfactory;

import net.skillfactory.interfaces.TriangleFactoryMethod;
import net.skillfactory.model.Triangle;
import net.skillfactory.model.TriangleFactoryMethodImpl;

public class App {

    public static void main( String[] args ) {

        TriangleFactoryMethod factory = new TriangleFactoryMethodImpl();
        Triangle t1 = factory.factoryMethod(12D, 12D, 12D);
        Triangle t2 = factory.factoryMethod(25D, 8D, 25D);
        Triangle t3 = factory.factoryMethod(10D, 4D, 8.50D);

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
    }
}
