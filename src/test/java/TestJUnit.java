import org.junit.*;

public class TestJUnit {

    @BeforeClass
    public static void setUpAll() {
        System.out.println("Statruje najpierw");
    }

    @Before
    public void setUpMethod(){
        System.out.println("Startuje przed każdym testem");
    }

    //testy maja być powtarzalne - before statruje przed kazdym testem test1 test2 test3
    //musi być powtarzalny i działać autonomicznie
    //esty mogą stanowić dokumentacje
    //nazwy mtedo nazywamy tak jak co maja zrobić np. shouldGivenSthAndReturnWhen Then
    /**
     *
     * given
     * when
     * then
     *
     * */


    @AfterClass
    public static void closeAll() {
        System.out.println("Koncze testy");
    }

    @After
    public void closeMethod(){
        System.out.println("Uruchamiam po każdym †eście");
    }

    @Test
    public void test1() {
        System.out.println("To jest pierwszy test1");
    }

    @Test
    public void test2() {
        System.out.println("To jest pierwszy test2");
    }

    @Test
    public void test3() {
        System.out.println("To jest pierwszy test3");
    }
}
