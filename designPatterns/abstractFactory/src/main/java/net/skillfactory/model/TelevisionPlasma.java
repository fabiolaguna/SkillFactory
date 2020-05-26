package net.skillfactory.model;

public class TelevisionPlasma extends Television {

    public TelevisionPlasma(){
        super();
        System.out.println("Plasma television created");
    }

    @Override
    public String toString() {
        return "TV = Plasma , " + super.toString();
    }
}
