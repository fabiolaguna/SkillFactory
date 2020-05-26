package net.skillfactory.model;

import net.skillfactory.interfaces.AbstractFactory;
import net.skillfactory.interfaces.IColour;

public class FactoryBlueLcd implements AbstractFactory {

    @Override
    public IColour createColour() {
        return new ColourBlue();
    }

    @Override
    public Television createTelevision() {
        return new TelevisionLcd();
    }
}
