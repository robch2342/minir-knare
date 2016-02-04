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


        double e = - 8;
        double f = - 6;

        assertEquals("Testar att addera negativa tal", -14, miniräknare.addition(e, f), 0);

        double g = - 10;
        double h = 100;

        assertEquals("Testar negativ och positiva ta", 90, miniräknare.addition(g, h),0);
    }

    @Test
    public void testPi() throws Exception {
        double pi = Math.PI;

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

        double e = - 7;
        double f = 8;

        assertEquals("Testar att multiplicera med negativa tal", -56, miniräknare.multiplikation(e, f), 0);

        double g = - 9;
        double h = - 3;

        assertEquals("Testar två negativa tal", 27, miniräknare.multiplikation(g, h), 0);
        }

    @Test
    public void testDivision() throws Exception {
        double a = 10;
        double b = 2;

        assertEquals("Testar division", 5, miniräknare.division(a, b), 0);

        double c = 2;
        double d = 14;

        assertEquals("Testar att dela ett mindre tal i ett större", 0.14, miniräknare.division(c, d), 1);
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

        double e = - 5;
        double f = - 7;

        assertEquals("Testar negativa tal", 2, miniräknare.subtraktion(e, f), 0);
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
        String input1 = "5";
        assertEquals("testar inputvalidatorn", 5, miniräknare.inputValidating(input1), 0);
        assertEquals(3.14159265, miniräknare.inputValidating("pi", 9), 0);
        assertEquals(3.141592654, miniräknare.inputValidating("pI"), 0);
        assertEquals(3.14159265359, miniräknare.inputValidating("PI", 12), 0);
        assertEquals(-3.141592654, miniräknare.inputValidating("-Pi"), 0);
    }

    @Test(expected = Exception.class)
    public void testInputValidatorException() throws Exception {
        miniräknare.inputValidating("asfds");
    }

    @Test
    public void testCheckAvsluta() throws Exception{
        String input1 = "x";
        String input2 = "avsluta";
        String input3 = "tiotusen";

        exit.expectSystemExit();
        miniräknare.checkAvsluta(input1);

        exit.expectSystemExit();
        miniräknare.checkAvsluta(input2);

        assertEquals("ska inte inte avsluta", false, miniräknare.checkAvsluta(input3));

    }

    @Test
    public void testParseString() {
        assertEquals("7", miniräknare.parseString("1 +  6.0"));
        assertEquals("9.7", miniräknare.parseString(" 15-5.3   "));
        assertEquals("-50", miniräknare.parseString("   -  5.0* 10"));
        assertEquals("-9", miniräknare.parseString("27/-3 "));
        assertEquals("Syntax error", miniräknare.parseString("sgs"));
        assertEquals("Syntax error", miniräknare.parseString("1+"));
        assertEquals("Syntax error", miniräknare.parseString("5*35-"));
        assertEquals("Syntax error", miniräknare.parseString("345/3g36"));
        assertEquals("Syntax error", miniräknare.parseString("sgs-45"));
        assertEquals("678", miniräknare.parseString("678"));
        assertEquals("-678", miniräknare.parseString("-678.000"));
        assertEquals("Syntax error", miniräknare.parseString("56sqrt89"));
        assertEquals("4.141592654", miniräknare.parseString("1 +pi"));
        assertEquals("-2.141592654", miniräknare.parseString("-pi+1"));
    }

}

