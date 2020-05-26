package net.skillfactory.model;

public class IsoscelesTriangle extends Triangle {

    public IsoscelesTriangle(Double firstSide, Double secondSide, Double thirdSide){
        super(firstSide,secondSide,thirdSide);
    }

    @Override
    public String toString() {
        return super.toString() + "Triangle type: Isosceles";
    }
}
