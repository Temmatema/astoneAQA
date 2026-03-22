package lesson_7_testng;

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
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Недопустимая операция: " + operation);
        };
    }

    public static boolean isNumbersEqual(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) {
    }
}