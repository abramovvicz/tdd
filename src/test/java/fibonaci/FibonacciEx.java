package fibonaci;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

public class FibonacciEx {
    Fibonacci fibonacci;
    @Rule
    public ExpectedException exepszon = ExpectedException.none();
    @Test
    public void shouldBeExc(){
        exepszon.expectMessage("liczba nie może być ujemna");
        exepszon.expect(IllegalArgumentException.class);
    }

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @Test
    public void shouldBeExp() {
        try {
            fibonacci.countFibbonacci(-5);
            fail("Should be expetion");
        } catch (IllegalArgumentException e) {
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBeExp2() {
        fibonacci.countFibbonacci(-5);

    }
    @Test
    public void testRek(){
        fibonacci.rekurencja(6);
    }

}
