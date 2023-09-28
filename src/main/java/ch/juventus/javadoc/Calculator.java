package ch.juventus.javadoc;

/**
 * To demonstrate Mockito in the tests.
 */
public class Calculator {

    private final MathUtils mathUtils;

    public Calculator(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    public double multiplication(double ...numbers) {
        double result = 0;
        for (double number : numbers) {
            result = mathUtils.multiplication(result, number);
        }
        return result;
    }

}
