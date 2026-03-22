package lesson_5;

public class Main {
    public static boolean checkArray(String[][] array) {
        if (array == null || array.length != 4) {
            return false;
        }

        for (String[] strings : array) {
            if (strings == null || strings.length != 4) {
                return false;
            }
        }

        return true;
    }

    public static int myFunc(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (!checkArray(array)) {
            throw new MyArraySizeException("Массив должен быть 4х4");
        }

        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                        "Массив содержит некорректные данные\n" + 
                        "Строка " + (i + 1) + "\n" +
                        "Столбец " + (j + 1)
                    );
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
        };
        
        try {
            int result = myFunc(array);
            System.out.print("Результат сложения: " + result);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            String value = array[7][0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали: " + e.getMessage());
        }
    }
}