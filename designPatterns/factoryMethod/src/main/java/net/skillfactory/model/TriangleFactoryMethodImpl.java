package net.skillfactory.model;

import net.skillfactory.interfaces.TriangleFactoryMethod;

public class TriangleFactoryMethodImpl implements TriangleFactoryMethod {

    public Triangle factoryMethod(Double firstSide, Double secondSide, Double thirdSide) {

        if((Double.compare(firstSide, secondSide) == 0) && (Double.compare(secondSide, thirdSide) == 0) && (Double.compare(thirdSide, firstSide) == 0)){
            return new EquilateralTriangle(firstSide, secondSide, thirdSide);
        } else if((Double.compare(firstSide, secondSide) != 0) && (Double.compare(secondSide, thirdSide) != 0) && (Double.compare(thirdSide, firstSide) != 0)){
            return new ScaleneTriangle(firstSide, secondSide, thirdSide);
        } else {
            return new IsoscelesTriangle(firstSide, secondSide, thirdSide);
        }
    }
}
