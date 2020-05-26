package net.skillfactory.model;

import net.skillfactory.interfaces.IBadStateBook;

public class Stock implements IBadStateBook {

    public Stock() {
    }

    @Override
    public void update() {
        System.out.println("Stock le da de baja al libro.");
    }
}
