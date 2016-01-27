import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class MiniräknareTest {

    private Miniräknare miniräknare = new Miniräknare();

    @Rule // För att kunna testa avsluta metoden
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddition() throws Exception {
        double a = 5;
        double b = 5;

        assertEquals("Testar addition", 10, miniräknare.addition(a, b), 0);

        double c = 0;
        double d = 0;

        assertEquals("Testar addition", 0, miniräknare.addition(c, d),0);
    }

    @Test
    public void testPi() throws Exception {
        double pi = 3.1415;

        assertEquals("Testar pi", pi, miniräknare.pi(), 0);
    }

    @Test
    public void testMultiplikation() throws Exception{
        double a = 10;
        double b = 10;

        assertEquals("Testar multiplikation", 100, miniräknare.multiplikation(a, b), 0);

        double c = 10000;
        double d = 100000;

        assertEquals("Testar stora tal", 1000000000, miniräknare.multiplikation(c , d), 0);
        }

    @Test
    public void testDivision() throws Exception {
        double a = 10;
        double b = 2;

        assertEquals("Testar division", 5, miniräknare.division(a, b), 0);

        double c = 2;
        double d = 14;

        assertEquals("Testar att dela ett mindre tal i ett större", 0.14, miniräknare.division(c , d), 1);
    }

    @Test
    public void testKvadratroten() throws Exception{
        double a = 25;

        assertEquals("Testar kvadratroten",5, miniräknare.kvadratroten(a),0);
    }

    @Test
    public void testSubtraktion() throws Exception {
        double a = 7;
        double b = 4;

        assertEquals("Testar subtraktion", 3, miniräknare.subtraktion(a, b), 0);


        double c = 4;
        double d = 8;

        assertEquals("Testar att se om minustal fungerar", -4, miniräknare.subtraktion(c, d),0);
    }

    @Test
    public void testValidRaknesattMulti() throws Exception{
        String raknesatt = "*";
        assertEquals("teststar räknesättet", true, miniräknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidRaknesattSub() throws Exception{
        String raknesatt = "-";
        assertEquals("teststar räknesättet", true, miniräknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidRaknesattAdd() throws Exception{
        String raknesatt = "+";
        assertEquals("teststar räknesättet", true, miniräknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidraknesattDiv() throws Exception{
        String raknesatt = "/";
        assertEquals("testar räknesättet", true, miniräknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testRaknesattFail() throws Exception{
        String raknesatt = "något som inte finns";
        assertEquals("testar om räknesättet finns", false, miniräknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testAvsluta() throws Exception{
        exit.expectSystemExit();
        miniräknare.avsluta();
    }

    @Test
    public void testNoAvsluta() throws Exception{
        //passes
    }

    @Test
    public void testGetSumAdd() throws Exception{
        String raknesatt = "+";
        double input1 = 5;
        double input2 = 5;

        assertEquals("testar metoden getsum", 10, miniräknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testGetSumMulti() throws Exception{
        String raknesatt = "*";
        double input1 = 4;
        double input2 = 2;

        assertEquals("testar getsum multiplikation", 8, miniräknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testGetSumDiv() throws Exception{
        String raknesatt = "/";
        double input1 = 10;
        double input2 = 2;

        assertEquals("testar getsum division", 5, miniräknare.getSum(raknesatt,input1,input2), 0);
    }

    @Test
    public void testGetSumSub() throws Exception{
        String raknesatt = "-";
        double input1 = 4;
        double input2 = 2;

        assertEquals("testar getsum subtraktion", 2, miniräknare.getSum(raknesatt,input1,input2), 0);
    }

    @Test
    public void testInputValidator() throws Exception{
        String input = "5";

        assertEquals("testar inputvalidatorn", 5, miniräknare.inputValidating(input), 0);
    }

    @Test
    public void testInputValidator2() throws Exception{
        String input = "asdasd";

        assertEquals("testar om den returnerar 0", 0, miniräknare.inputValidating(input), 0);
    }
}

