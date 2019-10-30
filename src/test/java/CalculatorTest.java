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
}
