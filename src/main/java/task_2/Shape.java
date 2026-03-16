package task_2;

public interface Shape {
    double area();

    default double perimeter() {
        return 0;
    }
}