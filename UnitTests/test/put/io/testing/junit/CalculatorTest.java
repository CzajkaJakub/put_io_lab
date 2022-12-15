package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach // before all wykonuje sie tylko raz
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add() {
        //given
        int x = 5;
        int y = 10;
        int z = 1;
        int expectedResultXY = 15;
        int expectedResultXZ = 6;

        //when
        int result1 = calculator.add(x, y);
        int result2 = calculator.add(x, z);

        //then
        assertEquals(expectedResultXY, result1);
        assertEquals(expectedResultXZ, result2);
    }

    @Test
    void multiply() {
        //given
        int x = 3;
        int y = 2;
        int z = 1;
        int expectedResultXY = 6;
        int expectedResultXZ = 3;

        //when
        int result1 = calculator.multiply(x, y);
        int result2 = calculator.multiply(x, z);

        //then
        assertEquals(expectedResultXY, result1);
        assertEquals(expectedResultXZ, result2);
    }

    @Test
    void addPositiveNumbers() {
        //given
        int x = -3;
        int y = 10;
        int z = 1;
        int expectedResultYZ = 11;

        //when
        int result1 = calculator.addPositiveNumbers(y, z);

        //then
        assertEquals(expectedResultYZ, result1);
        assertThrows(IllegalArgumentException.class, () -> calculator.addPositiveNumbers(x, y) );
    }
}