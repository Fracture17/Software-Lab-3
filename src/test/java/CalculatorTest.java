import com.calculator.Calculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void basicAddition() {
        String expression = "1 + 2";
        double expected = 3.0;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void multipleAddition() {
        String expression = "1 + 2 + 5 + 12 + 3";
        double expected = 23.0;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void basicAdditionWithNegativeNumbers() {
        String expression = "-1 + 2";
        double expected = 1.0;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void basicAdditionWithNoSpaces() {
        String expression = "1+2";
        double expected = 3.0;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void negativeNumberAdditionWithNoSpaces() {
        String expression = "1+-2";
        double expected = -1.0;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void basicSubtraction() {
        String expression = "1 - 2";
        double expected = -1.0;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void multipleSubtraction() {
        String expression = "7 - 2 - 3 - 12";
        double expected = -10;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void basicMultiplication() {
        String expression = "7 * 3";
        double expected = 21;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void basicDivision() {
        String expression = "7 / 3";
        double expected = 2.33;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void basicModulus() {
        String expression = "25 % 7";
        double expected = 4;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void floatingPointOperands() {
        String expression = "3.6 + 2.1 - 3.5 * 4.2 - 1.1 / 5.01";
        double expected = -9.22;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void floatingPointModulus() {
        String expression = "5.4 % 1.6";
        double expected = 0.54;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void compoundExpressions() {
        String expression = "3.6 % 1.8 * 29 - -.5 + -3 * -0.3";
        double expected = 1.4;
        assertEquals(expected, calculator.calculate(expression), 0.1);
    }

    @Test
    public void divisionByZeroThrowException() {
        String expression = "1 / 0";

        try {
            double result = calculator.calculate(expression);
            System.out.println(result);
            assert false;
        }
        catch (ArithmeticException e) {

        }
    }

    @Test
    public void invalidCharacterThrowsException() {
        String expression = "a + 1";

        try {
            double result = calculator.calculate(expression);
            System.out.println(result);
            assert false;
        }
        catch (RuntimeException e) {

        }
    }

    @Test
    public void invalidSyntaxThrowsException() {
        String expression = "1 + + 1";

        try {
            double result = calculator.calculate(expression);
            System.out.println(result);
            assert false;
        }
        catch (RuntimeException e) {
        }
    }
}
