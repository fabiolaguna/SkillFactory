package net.skillfactory.model;

import net.skillfactory.interfaces.IColour;

public abstract class Television {

    private IColour colour;

    public Television(){
    }

    public void setColour(IColour colour){
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Colour = " + colour;
    }
}
