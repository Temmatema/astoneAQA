package lesson_7_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testFactorial() {
        Assertions.assertEquals(1, Main.factorial(0));
        Assertions.assertEquals(1, Main.factorial(1));
        Assertions.assertEquals(2, Main.factorial(2));
        Assertions.assertEquals(6, Main.factorial(3));
        Assertions.assertEquals(24, Main.factorial(4));
        Assertions.assertEquals(120, Main.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> Main.factorial(-1)); 
    }

    @Test
    public void testTriangleArea() {
        Assertions.assertEquals(10.0, Main.triangleArea(5.0, 4.0), 0.001);
        Assertions.assertEquals(15.0, Main.triangleArea(6.0, 5.0), 0.001);
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(-1.0, 4.0)); 
        assertThrows(IllegalArgumentException.class, () -> Main.triangleArea(5.0, -1.0));
    }

    @Test
    public void testCalculator() {
        Assertions.assertEquals(5, Main.calculator(2, 3, "+"));
        Assertions.assertEquals(-1, Main.calculator(2, 3, "-"));
        Assertions.assertEquals(6, Main.calculator(2, 3, "*"));
        Assertions.assertEquals(2, Main.calculator(6, 3, "/"));
        assertThrows(IllegalArgumentException.class, () -> Main.calculator(6, 0, "/")); 
        assertThrows(IllegalArgumentException.class, () -> Main.calculator(6, 3, "%")); 
    }

    @Test
    public void testIsInteger() {
        Assertions.assertTrue(Main.isNumbersEqual(5, 5));
        Assertions.assertFalse(Main.isNumbersEqual(5, 10));
    }
}
