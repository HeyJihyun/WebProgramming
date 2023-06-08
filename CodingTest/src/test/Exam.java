package test;

class Circle {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

}

public class Exam {
    public static void main(String[] args) {
        Circle pizza = new Circle(10);
        System.out.println(pizza.radius);
        Circle donut = new Circle(10);
        System.out.println(pizza.radius);
    }

}
