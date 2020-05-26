package net.skillfactory.model;

public class ScaleneTriangle extends Triangle {

    public ScaleneTriangle(Double firstSide, Double secondSide, Double thirdSide){
        super(firstSide,secondSide,thirdSide);
    }

    @Override
    public String toString() {
        return super.toString() + "Triangle type: Scalene";
    }
}
