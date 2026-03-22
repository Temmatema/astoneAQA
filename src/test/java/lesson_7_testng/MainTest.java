package lesson_7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testFactorial() {
        Assert.assertEquals(Main.factorial(0), 1);
        Assert.assertEquals(Main.factorial(1), 1);
        Assert.assertEquals(Main.factorial(2), 2);
        Assert.assertEquals(Main.factorial(3), 6);
        Assert.assertEquals(Main.factorial(4), 24);
        Assert.assertEquals(Main.factorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Main.factorial(-1);
    }

    @Test
    public void testTriangleArea() {
        Assert.assertEquals(Main.triangleArea(5.0, 4.0), 10.0, 0.001);
        Assert.assertEquals(Main.triangleArea(6.0, 5.0), 15.0, 0.001);
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
        Assert.assertEquals(Main.calculator(2, 3, "+"), 5);
        Assert.assertEquals(Main.calculator(2, 3, "-"), -1);
        Assert.assertEquals(Main.calculator(2, 3, "*"), 6);
        Assert.assertEquals(Main.calculator(6, 3, "/"), 2);
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