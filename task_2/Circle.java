public class Circle implements Shape {
    int radius;
    String fillColor;
    String borderColor;

    Circle(int radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}