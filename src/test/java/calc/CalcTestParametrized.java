package calc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalcTestParametrized {
    @Parameter(0)
    public int a;

    @Parameter(1)
    public int b;

    @Parameter(2)
    public int result;

    Calculator calculator;

//    public CalcTestParametrized(int a, int b, int result) {
//        this.a = a;
//        this.b = b;
//        this.result = result;
//    }

    @Parameters(name = "{index} : {0} + {1} = {2}")
    public static Collection<? extends Object> parameters() {
        return Arrays.asList(new Object[][]{{2, 2, 4}, {7, 3, 10}, {4, 5, 9}, {3, 4, 7}});
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void add_test() {
        assertEquals(result, calculator.add(a, b));
    }

}
