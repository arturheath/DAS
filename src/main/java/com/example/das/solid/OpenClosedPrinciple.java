package com.example.das.solid;

public class OpenClosedPrinciple {
    // Interface adhering to OCP
    interface Shape {
        double calculateArea();
    }

    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    static class AreaCalculator {
        public double calculateTotalArea(Shape[] shapes) {
            double area = 0;
            for (Shape shape : shapes) {
                area += shape.calculateArea();
            }
            return area;
        }
    }
}
