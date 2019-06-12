package intToBin;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IntToBinTest {

    IntToBin intToBin;

    @Test
    @Parameters({"100, 0", "101,1", "1001, 2", "1000100, 3", "10110010000, 2"})
    public void checkZero(String a, int result) {
        System.out.println(intToBin.howManyZero(a));
        assertEquals(result, intToBin.howManyZero(a));
    }


    @Test
    @Parameters({"4, 0", "5,1", "9, 2", "68, 3", "1424, 2"})
    public void checkZero2(int a, int result) {
        int res = intToBin.howManyZero(intToBin.countIntToBin(a));
        Assert.assertEquals(result, res);

    }

    @Before
    public void setUp() throws Exception {
        intToBin = new IntToBin();
    }

    @Test
    @Parameters({"0,0", "1,1", "5,101"})
    public void countIntToBin(int a, String b) {
        assertEquals(b, intToBin.countIntToBin(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void countIntToBin() {
        intToBin.countIntToBin(-1);
    }
}