package net.skillfactory.interfaces;

import net.skillfactory.model.Television;

public interface AbstractFactory {

    IColour createColour();
    Television createTelevision();
}
