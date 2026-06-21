package com.cognizant.designpatterns;

// Factory Pattern - Instead of creating objects directly with "new",
// we use a factory method. This keeps the code flexible.
// Example: A pizza shop doesn't tell customers HOW the pizza is made,
// they just order by name.

public interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// The factory decides which shape to create based on the input
class ShapeFactory {

    public static Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        switch (shapeType.toUpperCase()) {
            case "CIRCLE":    return new Circle();
            case "RECTANGLE": return new Rectangle();
            case "TRIANGLE":  return new Triangle();
            default:          return null;
        }
    }
}

class FactoryTest {

    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("CIRCLE");
        circle.draw();

        Shape rectangle = ShapeFactory.createShape("RECTANGLE");
        rectangle.draw();

        Shape triangle = ShapeFactory.createShape("TRIANGLE");
        triangle.draw();
    }
}
