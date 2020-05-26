package net.skillfactory.model;

import net.skillfactory.interfaces.IBadStateBook;

public class Sales implements IBadStateBook {

    public Sales() {
    }

    @Override
    public void update() {
        System.out.println("Compras pide nueva cotizacion del libro.");
    }
}
