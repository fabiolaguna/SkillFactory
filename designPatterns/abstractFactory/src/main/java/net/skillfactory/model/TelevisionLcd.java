package net.skillfactory.model;

public class TelevisionLcd extends Television {

    public TelevisionLcd(){
        super();
        System.out.println("Lcd television created");
    }

    @Override
    public String toString() {
        return "TV = Lcd , " + super.toString();
    }
}
