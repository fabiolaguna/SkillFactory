package net.skillfactory.model;

import net.skillfactory.interfaces.AbstractFactory;
import net.skillfactory.interfaces.IColour;

public class FactoryYellowPlasma implements AbstractFactory {

    @Override
    public IColour createColour() {
        return new ColourYellow();
    }

    @Override
    public Television createTelevision() {
        return new TelevisionPlasma();
    }
}
