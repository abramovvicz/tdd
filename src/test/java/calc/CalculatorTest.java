package calc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omg.PortableInterceptor.INACTIVE;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

//importujemy static zeby nie pisać Asssert.assertEquals
public class CalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator(); //nowa instancja naszej klasy
    }
//test powinien robić jeden test czyli przekopiowywac metody
    //@Ignore - ingoruje testy

    @Test
    public void shouldBeSumAndB() {
//można też puhlic void add_test
        int res = calculator.add(3, 4);
        assertEquals(7, res);
    }

    @Test
    public void shouldBeArithmeticExcpetion() {
        try {
            calculator.add(Integer.MAX_VALUE, 5);
//            calculator.add(10, 5);
            fail("Should be Arithmetic Excpetion"); //failuje nam
        } catch (ArithmeticException e) {

        }
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeArithmeticExcpetion1() {
        calculator.add(Integer.MAX_VALUE, 5);
    }

    @Test
    public void divShouldBeErrorIllegalArgumentExeption() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Nie dziel przez zero");
        calculator.div(1.4, 0.0);
    }

    //możemy sprawdzać nasze exceptiony^^

    @Test
    public void testDivShouldBeDivided() {
        assertEquals(0.7, calculator.div(1.4, 2.0), 0.00001);
        //delta - pokazuje do ilu po przecinku dzielenie ma się zgadzać, zakres różnic
    }

    @Test
    public void shouldBeZero() {
//można też puhlic void add_test
        int res = calculator.add(0, 0);
        assertEquals(0, res);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeZero3() {
//można też puhlic void add_test
        int res = calculator.add(Integer.MIN_VALUE, -Integer.MIN_VALUE);
        assertEquals(0, res);
    }
    @Test
    public void shouldBeZero2() {
//można też puhlic void add_test
        int res = calculator.add(-2, 2);
        assertEquals(0, res);
    }

    @Test
    public void shouldBeZero4(){
        assertEquals(0, calculator.add(Integer.MAX_VALUE, -Integer.MAX_VALUE));
    }




}