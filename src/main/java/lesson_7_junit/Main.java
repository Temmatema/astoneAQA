package lesson_7_junit;

public class Main {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }

        if (n == 0) {
            return 1;
        } 
        return n * factorial(n - 1);
    }

    public static double triangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными числами");
        }
        return 0.5 * base * height;
    }

    public static int calculator(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Недопустимая операция: " + operation);
        }
    }

    public static boolean isNumbersEqual(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) {
    }
}