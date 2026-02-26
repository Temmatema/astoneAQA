public class Rectangle implements Shape {
    int height;
    int width;
    String fillColor;
    String borderColor;

    Rectangle(int width, int height, String fillColor, String borderColor) {
        this.height = height;
        this.width = width;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * height + 2 * width;
    }
}
