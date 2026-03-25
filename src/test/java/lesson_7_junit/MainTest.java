package lesson_7_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    MathUtils mathUtils = new MathUtils();

    @Test
    public void testFactorial() {
        Assertions.assertEquals(1, mathUtils.factorial(0));
        Assertions.assertEquals(1, mathUtils.factorial(1));
        Assertions.assertEquals(2, mathUtils.factorial(2));
        Assertions.assertEquals(6, mathUtils.factorial(3));
        Assertions.assertEquals(24, mathUtils.factorial(4));
        Assertions.assertEquals(120, mathUtils.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> mathUtils.factorial(-1));
    }

    @Test
    public void testTriangleArea() {
        Assertions.assertEquals(10.0, mathUtils.triangleArea(5.0, 4.0), 0.001);
        Assertions.assertEquals(15.0, mathUtils.triangleArea(6.0, 5.0), 0.001);
        assertThrows(IllegalArgumentException.class, () -> mathUtils.triangleArea(-1.0, 4.0));
        assertThrows(IllegalArgumentException.class, () -> mathUtils.triangleArea(5.0, -1.0));
    }

    @Test
    public void testCalculator() {
        Assertions.assertEquals(5, mathUtils.calculator(2, 3, "+"));
        Assertions.assertEquals(-1, mathUtils.calculator(2, 3, "-"));
        Assertions.assertEquals(6, mathUtils.calculator(2, 3, "*"));
        Assertions.assertEquals(2, mathUtils.calculator(6, 3, "/"));
        assertThrows(IllegalArgumentException.class, () -> mathUtils.calculator(6, 0, "/"));
        assertThrows(IllegalArgumentException.class, () -> mathUtils.calculator(6, 3, "%"));
    }

    @Test
    public void testIsInteger() {
        Assertions.assertTrue(mathUtils.isNumbersEqual(5, 5));
        Assertions.assertFalse(mathUtils.isNumbersEqual(5, 10));
    }
}
