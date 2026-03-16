package task_2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3, "blue", "red");
        Rectangle rectangle = new Rectangle(20, 20, "orange", "black");
        Triangle triangle = new Triangle(10, 10, 15, "pink", "white");

        System.out.println(
            "Площадь круга: " + circle.area() + "\n" + 
            "Периметр круга: " + circle.perimeter() + "\n" +
            "Цвет заливки: " + circle.getFillColor() + "\n" +
            "Цвет границ: " + circle.getBorderColor() + "\n"
        );

        System.out.println(
            "Площадь прямоугольника: " + rectangle.area() + "\n" + 
            "Периметр прямоугольника: " + rectangle.perimeter() + "\n" +
            "Цвет заливки: " + rectangle.getFillColor() + "\n" +
            "Цвет границ: " + rectangle.getBorderColor() + "\n"
        );

        System.out.println(
            "Площадь треугольника: " + triangle.area() + "\n" + 
            "Периметр треугольника: " + triangle.perimeter() + "\n" +
            "Цвет заливки: " + triangle.getFillColor() + "\n" +
            "Цвет границ: " + triangle.getBorderColor() + "\n"
        );
    }
}