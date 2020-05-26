package net.skillfactory.model;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(Double firstSide, Double secondSide, Double thirdSide){
        super(firstSide,secondSide,thirdSide);
    }

    @Override
    public String toString() {
        return super.toString() + "Triangle type: Equilateral";
    }
}
