package task_2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3, "blue", "red");
        Rectangle rectangle = new Rectangle(20, 20, "orange", "black");
        Triangle triangle = new Triangle(10, 10, 15, "pink", "white");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}