package net.skillfactory.model;

import net.skillfactory.interfaces.IColour;

public class ColourBlue implements IColour {

    public ColourBlue() {
        System.out.println("Blue colour created");
    }

    @Override
    public Television paintTelevision(Television television) {
        television.setColour(this);
        return television;
    }

    @Override
    public String toString() {
        return "Blue";
    }
}
