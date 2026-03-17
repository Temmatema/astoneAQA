package task_2;

public class Circle implements Shape {
    private final int radius;
    private final String fillColor;
    private final String borderColor;

    public Circle(int radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
    
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}