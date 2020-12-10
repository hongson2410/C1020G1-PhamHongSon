package bai8_cleancode_refactoring.thuc_hanh.refactoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    public static final char ADDITION = '+';

    @Test
    @DisplayName("Testing addition")
   public void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    public void testCalculateSub() {
        int firstOperand = 2;
        int secondOperand = 1;
        char operand = '-';
        int expected = 1;

        int result = Calculator.calculate(firstOperand, secondOperand, operand);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    public void testCalculateMul() {
        int firstOperand = 2;
        int secondOperand = 2;
        char operand = '*';
        int expected = 4;

        int result = Calculator.calculate(firstOperand, secondOperand, operand);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    public void testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        char operand = '/';
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, operand);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    public void testCalculateDivByZero() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operand = '/';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, operand);});
    }

    @Test
    @DisplayName("Testing wrong operator")
    public void testCalculateWrongOperator() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operand = '=';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, operand);});
    }
}
