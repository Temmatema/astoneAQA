package task_2;

public interface Shape {
    double area();
    double perimeter();
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Площадь: " + area());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
    }
}