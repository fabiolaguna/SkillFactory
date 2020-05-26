package net.skillfactory.model;

import net.skillfactory.interfaces.IColour;

public class ColourYellow implements IColour {

    public ColourYellow() {
        System.out.println("Yellow colour created");
    }

    @Override
    public Television paintTelevision(Television television) {
        television.setColour(this);
        return television;
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
