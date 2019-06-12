package multiplication;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MultiplicationTest {
    Multiplication multiplication;


    @Before
    public void setUp() {
        //given
        multiplication = new Multiplication();
    }

    @Test
    @Parameters
    public void multiplicationCheck(int result, int a, int b) {
        int check = multiplication.countMultiplication(a, b);
        Assert.assertEquals(result, check);
    }


    private Object[] parametersForMultiplicationCheck() {
        return new Object[]{
                new Object[]{1, 1, 1},
                new Object[]{2, 1, 2},
                new Object[]{-1, -1, 1},
                new Object[]{1, -1, -1},
                new Object[]{6, 2, 3},
                new Object[]{0, 2, 0},
                new Object[]{0, 0, 0},
                new Object[]{0, 0, 1}

        };
    }

}
