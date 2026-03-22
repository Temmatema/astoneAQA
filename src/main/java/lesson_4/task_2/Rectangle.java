package lesson_4.task_2;

public class Rectangle implements Shape {
    private final int height;
    private final int width;
    private final String fillColor;
    private final String borderColor;

    public Rectangle(int width, int height, String fillColor, String borderColor) {
        this.height = height;
        this.width = width;
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
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * height + 2 * width;
    }
}