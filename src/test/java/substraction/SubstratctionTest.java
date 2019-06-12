package substraction;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnitParamsRunner.class)
public class SubstratctionTest {
    Substraction substractionTest;

    @Before
    public void setUp() {
        //Given
        substractionTest = new Substraction();
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();




    @Test
    @Parameters
//    @Parameters({"2,4,2", "0,2,2", "-1,3,4", "-7,-3,4", "1,-3,-4", "1, Integer.MAX_VALUE, Integer.MAX_VALUE"})
    public void checkSubstraction(double result, double a, double b) {
        //when
        double sub = substractionTest.substract(a, b);
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Some message to Exception");
        //then
        assertEquals(result, sub, 0.0);
        assertNull(result); // dodatkowa assercja czy obiekt został zwrócony


    }

    private Object[] parametersForCheckSubstraction() {
        return new Object[]{
                new Object[]{0, 0, 0},
                new Object[]{-1, 0, -1},
                new Object[]{2, 4, 2},
                new Object[]{0, 2, 2},
                new Object[]{-1, 3, 4},
                new Object[]{1, -3, -4},
                new Object[]{0, Double.MAX_VALUE, Double.MAX_VALUE},
                new Object[]{1, Double.MIN_VALUE, Double.MAX_VALUE},
                new Object[]{-1, Double.MAX_VALUE, Double.MIN_VALUE},
                new Object[]{0, Double.MIN_VALUE, Double.MIN_VALUE}};
    }


    @After
    public void closeMethod() {
        System.out.format("%s\n", "zamykanie metody");
    }

}
