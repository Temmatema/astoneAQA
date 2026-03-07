import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testFactorial() {
        assertEquals(1, Main.factorial(0));
        assertEquals(1, Main.factorial(1));
        assertEquals(2, Main.factorial(2));
        assertEquals(6, Main.factorial(3));
        assertEquals(24, Main.factorial(4));
        assertEquals(120, Main.factorial(5));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Main.factorial(-1);
    }

    @Test
    public void testTriangleArea() {
        assertEquals(10.0, Main.triangleArea(5.0, 4.0), 0.001);
        assertEquals(15.0, Main.triangleArea(6.0, 5.0), 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaNegativeBase() {
        Main.triangleArea(-1.0, 4.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaNegativeHeight() {
        Main.triangleArea(5.0, -1.0);
    }

    @Test
    public void testCalculator() {
        assertEquals(5, Main.calculator(2, 3, "+"));
        assertEquals(-1, Main.calculator(2, 3, "-"));
        assertEquals(6, Main.calculator(2, 3, "*"));
        assertEquals(2, Main.calculator(6, 3, "/"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculatorDivisionByZero() {
        Main.calculator(6, 0, "/");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculatorUnknownOperator() {
        Main.calculator(6, 3, "%");
    }

    @Test
    public void testIsNumbersEqual() {
        assertTrue(Main.isNumbersEqual(5, 5));
        assertFalse(Main.isNumbersEqual(5, 10));
    }
}