import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void verifySumOfIntegers1() {
        int expectedSum = 11;
        int actualSum = calculator.getSum(5, 6);
        Assert.assertEquals("Sum of integers is incorrect", expectedSum, actualSum);
    }

    @Test
    public void verifyDifferenceOfIntegers2() {
        int expectedDiffPositive = 3;
        int expectedDiffNegative = -3;
        int expectedDiffPositiveAndZero = 13;

        int actualDiffPositive = calculator.getDifference(7, 4);
        int actualDiffNegative = calculator.getDifference(-8, -5);
        int actualDiffPositiveAndZero = calculator.getDifference(13, 0);
        Assert.assertEquals("Difference  of positive integers is incorrect", expectedDiffPositive, actualDiffPositive);
        Assert.assertEquals("Difference of negative integers is incorrect", expectedDiffNegative, actualDiffNegative);
        Assert.assertEquals("Difference of positive and zero integers is incorrect", expectedDiffPositiveAndZero,
                            actualDiffPositiveAndZero);
    }
}
