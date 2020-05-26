package net.skillfactory.model;

import net.skillfactory.interfaces.AbstractFactory;
import net.skillfactory.interfaces.IColour;

public class Product {

    private AbstractFactory factory;
    private Television television;

    public Product(AbstractFactory factory){
        this.factory = factory;
        this.television = factory.createTelevision();
        IColour colour = factory.createColour();
        television = colour.paintTelevision(television);
    }

    @Override
    public String toString() {
        return "Product: " + television.toString();
    }
}
