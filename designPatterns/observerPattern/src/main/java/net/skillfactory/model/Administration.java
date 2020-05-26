package net.skillfactory.model;

import net.skillfactory.interfaces.IBadStateBook;

public class Administration implements IBadStateBook {

    public Administration() {
    }

    @Override
    public void update() {
        System.out.println("La administracion se queja por el estado del libro");
    }
}
