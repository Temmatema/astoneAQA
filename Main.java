import java.util.Arrays;

public class Main {

    /* Задание 1 */
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /* Задание 2 */
    public static void checkSumSign() {
        int a = 15;
        int b = -30;

        int result = a + b;

        if (result >= 0) {
            System.out.print("Сумма положительная");
        } else {
            System.out.print("Сумма отрицательная");
        }
    }

    /* Задание 3 */

    public static void printColor() {
        int value = 10;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100){
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    /* Задание 4 */

    public static void compareNumbers() {
        int a = 5, b = 8;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /* Задание 5 */

    public static boolean checkSumRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /* Задание 6 */

    public static void printPositiveNumber(int number) {
        if (number >= 0) {
            System.out.print("Число положительное");
        } else {
            System.out.print("Число отрицательное");
        }
    }

    /* Задание 7 */

    public static boolean isNegative(int number) {
        return number < 0;
    }

    /* Задание 8 */

    public static void printString(String str, int count) {
        while (count > 0) {
            System.out.println(str);
            count--;
        }
    }

    /* Задание 9 */

    public static boolean checkYearLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /* Задание 10 */

    public static void replaceNumbersInArray() {
        int[] array = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];

            System.out.print(array[i] + " ");
        }
    }

    /* Задание 11 */

    public static void fillArray() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;

            System.out.print(array[i] + " ");
        }
    }

    /* Задание 12 */
    public static void arrayCycle() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        //проверяем результат
        for (int j : array) {
            System.out.println(j);
        }
    }

    /* Задание 13 */
    public static void squareTwoIntegerArray() {
        int[][] matrix = new int[7][7];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }

        //результат в консоль
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    /* Задание 14 */

    public static int[] createAndReturnArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);

        return arr;
    }

    public static void main(String[] args) {
    }
}