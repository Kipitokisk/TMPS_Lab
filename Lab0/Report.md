# **SOLID Principles**

## **Introduction**
The SOLID principles are a set of guidelines for writing clean, maintainable, and extendable object-oriented code. In this report, we'll focus on two key principles from SOLID: the **Single Responsibility Principle (SRP)** and the **Open/Closed Principle (OCP)**. The accompanying Java code example demonstrates how these principles can be applied to a simple program that calculates the area of different shapes.

---

## **Code Overview**

The provided code consists of:
1. A `ShapeAreaCalculator` class responsible for calculating the area of any shape.
2. A `Shape` interface that different shapes such as `Rectangle`, and `Square` implement.
3. A `Main` class that demonstrates the usage of the `ShapeAreaCalculator` to calculate and print the areas of different shapes.

``` Java
public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}

public interface Shape {
    double area();
}

public class Rectangle implements Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

public class Square implements Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape square = new Square(4);
        Shape rectangle = new Rectangle(3, 4);
        AreaCalculator areaCalculator = new AreaCalculator();

        System.out.println("Square area = " + areaCalculator.calculateArea(square));
        System.out.println("Rectangle area = " + areaCalculator.calculateArea(rectangle));
    }
}
```
---
## **Single Responsibility Principle**
### **Explanation**
The **Single Responsibility Principle** states that a class should have only one reason to change, meaning it should only have one job or responsibility. This makes the class more focused, easier to understand, and simpler to maintain.
### **Application in code**
In our example, the `ShapeAreaCalculator` class has one clear responsibility: to calculate the area of any given shape. It does not handle other concerns such as shape creation, printing results, or storing shapes. Its sole job is to compute the area of a shape, ensuring that changes related to calculating the area are isolated to this class alone.
``` Java
public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}
```
---
## **Open/Closed Principle**
### **Explanation**
The **Open/Closed Principle** suggests that a class should be open for extension but closed for modification. This means we should be able to add new functionality without altering the existing codebase, which avoids unintended side effects and promotes code reuse.
### **Application in code**
The `Shape` interface and its various implementations (e.g., `Rectangle`, `Square`) illustrate the Open/Closed Principle. The system is open for extension because we can add new shapes by implementing the Shape interface, without changing the ShapeAreaCalculator or other existing classes.
``` Java
public interface Shape {
    double area();
}

public class Rectangle implements Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

public class Square implements Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}
```
---
## **Conclusion**
By adhering to the Single Responsibility Principle (SRP) and the Open/Closed Principle (OCP), the code in this example becomes modular, maintainable, and easily extensible. Following these SOLID principles leads to more robust, scalable software that can adapt to future changes without sacrificing quality or stability.

The approach demonstrated here can be applied to more complex systems, ensuring that each component has a clear responsibility and that the system is open to growth while preserving existing functionality.

