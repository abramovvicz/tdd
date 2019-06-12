package fibonaci;

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
public class FibonacciTest {

    @Parameter(0)
    public int a;
    @Parameter(1)
    public int result;
    Fibonacci fibonacci;

    @Parameters(name = "for : {0} should be {1}")
    public static Collection<? extends Object> paramterize() {
        return Arrays.asList(new Object[][]{{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4,3},{5, 5}, {6, 8}, {7, 13}, {8, 21}});
    }

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @Test
    public void countFibbonacci() {
        assertEquals(result, fibonacci.countFibbonacci(a));
    }
}