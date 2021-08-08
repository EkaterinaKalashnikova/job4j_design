package ru.job4j.ocp.shapesolution;

public class AreaCalculator {
    public double areaCalc(Shape... shapes) {
        double totalArea = 0;
        for (var shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }
}
