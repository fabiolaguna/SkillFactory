package net.skillfactory.model;

public abstract class Triangle {

    private Double firstSide;
    private Double secondSide;
    private Double thirdSide;

    public Triangle(Double firstSide, Double secondSide, Double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public String toString() {
        return "FirstSide = " + firstSide +
                ", SecondSide = " + secondSide +
                ", ThirdSide = " + thirdSide + ". ";
    }
}
