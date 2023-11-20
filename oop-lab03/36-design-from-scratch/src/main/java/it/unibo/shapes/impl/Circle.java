package main.java.it.unibo.shapes.impl;

import main.java.it.unibo.shapes.api.Shape;

public class Circle implements Shape {
    private final double radius;
    
    public Circle (final double radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }
}
