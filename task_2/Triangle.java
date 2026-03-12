public class Triangle implements Shape {
    int sideA;
    int sideB;
    int sideC;
    String fillColor;
    String borderColor;

    Triangle(int sideA, int sideB, int sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }
}