package ch.juventus.javadoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    @Mock
    private MathUtils mathUtils;
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator(mathUtils);
    }

    @Test
    public void multiplicationWithMockedMathUtils() {
        // given
        when(mathUtils.multiplication(anyDouble(), anyDouble())).thenReturn(10d);
        // when
        double result = calculator.multiplication(1, 2, 3);
        // then
        assertEquals(10, result);
    }


}