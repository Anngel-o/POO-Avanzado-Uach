package Visitor;

interface Shape {
    void accept(Visitor visitor);
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Circle circle);
    void visit(Square square);
}

class AreaCalculator implements Visitor {
    private double totalArea;

    public double getTotalArea() {
        return totalArea;
    }

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        totalArea += area;
    }

    @Override
    public void visit(Square square) {
        double area = Math.pow(square.getSide(), 2);
        totalArea += area;
    }
}

class PerimeterCalculator implements Visitor {
    private double totalPerimeter;

    public double getTotalPerimeter() {
        return totalPerimeter;
    }

    @Override
    public void visit(Circle circle) {
        double perimeter = 2 * Math.PI * circle.getRadius();
        totalPerimeter += perimeter;
    }

    @Override
    public void visit(Square square) {
        double perimeter = 4 * square.getSide();
        totalPerimeter += perimeter;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(4);

        AreaCalculator areaCalculator = new AreaCalculator();
        PerimeterCalculator perimeterCalculator = new PerimeterCalculator();

        circle.accept(areaCalculator);
        circle.accept(perimeterCalculator);

        square.accept(areaCalculator);
        square.accept(perimeterCalculator);

        System.out.println("Area total: " + areaCalculator.getTotalArea());
        System.out.println("Perimeter total: " + perimeterCalculator.getTotalPerimeter());
    }
}

