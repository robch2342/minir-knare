import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class MiniraknareTest {

    private Miniraknare miniraknare = new Miniraknare();

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

        assertEquals("Testar addition", 10, miniraknare.addition(a, b), 0);

        double c = 0;
        double d = 0;

        assertEquals("Testar addition", 0, miniraknare.addition(c, d),0);


        double e = - 8;
        double f = - 6;

        assertEquals("Testar att addera negativa tal", -14, miniraknare.addition(e, f), 0);

        double g = - 10;
        double h = 100;

        assertEquals("Testar negativ och positiva ta", 90, miniraknare.addition(g, h),0);
    }

    @Test
    public void testPi() throws Exception {
        double pi = Math.PI;

        assertEquals("Testar pi", pi, miniraknare.pi(), 0);
    }

    @Test
    public void testMultiplikation() throws Exception{
        double a = 10;
        double b = 10;

        assertEquals("Testar multiplikation", 100, miniraknare.multiplikation(a, b), 0);

        double c = 10000;
        double d = 100000;

        assertEquals("Testar stora tal", 1000000000, miniraknare.multiplikation(c , d), 0);

        double e = - 7;
        double f = 8;

        assertEquals("Testar att multiplicera med negativa tal", -56, miniraknare.multiplikation(e, f), 0);

        double g = - 9;
        double h = - 3;

        assertEquals("Testar två negativa tal", 27, miniraknare.multiplikation(g, h), 0);
        }

    @Test
    public void testDivision() throws Exception {
        double a = 10;
        double b = 2;

        assertEquals("Testar division", 5, miniraknare.division(a, b), 0);

        double c = 2;
        double d = 14;

        assertEquals("Testar att dela ett mindre tal i ett större", 0.14, miniraknare.division(c, d), 1);
    }

    @Test
    public void testKvadratroten() throws Exception{
        double a = 25;

        assertEquals("Testar kvadratroten",5, miniraknare.kvadratroten(a),0);
    }

    @Test
    public void testSubtraktion() throws Exception {
        double a = 7;
        double b = 4;

        assertEquals("Testar subtraktion", 3, miniraknare.subtraktion(a, b), 0);


        double c = 4;
        double d = 8;

        assertEquals("Testar att se om minustal fungerar", -4, miniraknare.subtraktion(c, d),0);

        double e = - 5;
        double f = - 7;

        assertEquals("Testar negativa tal", 2, miniraknare.subtraktion(e, f), 0);
    }

    @Test
    public void testValidRaknesattMulti() throws Exception{
        String raknesatt = "*";
        assertEquals("teststar räknesättet", true, miniraknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidRaknesattSub() throws Exception{
        String raknesatt = "-";
        assertEquals("teststar räknesättet", true, miniraknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidRaknesattAdd() throws Exception{
        String raknesatt = "+";
        assertEquals("teststar räknesättet", true, miniraknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidraknesattDiv() throws Exception{
        String raknesatt = "/";
        assertEquals("testar räknesättet", true, miniraknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testRaknesattFail() throws Exception{
        String raknesatt = "något som inte finns";
        assertEquals("testar om räknesättet finns", false, miniraknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testAvsluta() throws Exception{
        exit.expectSystemExit();
        miniraknare.avsluta();
    }

    @Test
    public void testGetSumAdd() throws Exception{
        String raknesatt = "+";
        double input1 = 5;
        double input2 = 5;

        assertEquals("testar metoden getsum", 10, miniraknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testGetSumMulti() throws Exception{
        String raknesatt = "*";
        double input1 = 4;
        double input2 = 2;

        assertEquals("testar getsum multiplikation", 8, miniraknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testGetSumDiv() throws Exception{
        String raknesatt = "/";
        double input1 = 10;
        double input2 = 2;

        assertEquals("testar getsum division", 5, miniraknare.getSum(raknesatt,input1,input2), 0);
    }

    @Test
    public void testGetSumSub() throws Exception{
        String raknesatt = "-";
        double input1 = 4;
        double input2 = 2;

        assertEquals("testar getsum subtraktion", 2, miniraknare.getSum(raknesatt,input1,input2), 0);
    }

    @Test
    public void testInputValidator() throws Exception{
        String input1 = "5";
        assertEquals("testar inputvalidatorn", 5, miniraknare.inputValidating(input1), 0);
        assertEquals(3.14159265, miniraknare.inputValidating("pi", 9), 0);
        assertEquals(3.141592654, miniraknare.inputValidating("pI"), 0);
        assertEquals(3.14159265359, miniraknare.inputValidating("PI", 12), 0);
        assertEquals(-3.141592654, miniraknare.inputValidating("-Pi"), 0);
    }

    @Test(expected = Exception.class)
    public void testInputValidatorException() throws Exception {
        miniraknare.inputValidating("asfds");
    }

    @Test
    public void testCheckAvsluta() throws Exception{
        String input1 = "x";
        String input2 = "avsluta";
        String input3 = "tiotusen";

        exit.expectSystemExit();
        miniraknare.checkAvsluta(input1);

        exit.expectSystemExit();
        miniraknare.checkAvsluta(input2);

        assertEquals("ska inte inte avsluta", false, miniraknare.checkAvsluta(input3));

    }

    @Test
    public void testParseString() {
        assertEquals("7", miniraknare.parseString("1 +  6.0"));
        assertEquals("9.7", miniraknare.parseString(" 15-5.3   "));
        assertEquals("-50", miniraknare.parseString("   -  5.0* 10"));
        assertEquals("-9", miniraknare.parseString("27/-3 "));
        assertEquals("Syntax error", miniraknare.parseString("sgs"));
        assertEquals("Syntax error", miniraknare.parseString("1+"));
        assertEquals("Syntax error", miniraknare.parseString("5*35-"));
        assertEquals("Syntax error", miniraknare.parseString("345/3g36"));
        assertEquals("Syntax error", miniraknare.parseString("sgs-45"));
        assertEquals("678", miniraknare.parseString("678"));
        assertEquals("-678", miniraknare.parseString("-678.000"));
        assertEquals("Syntax error", miniraknare.parseString("56sqrt89"));
        assertEquals("4.141592654", miniraknare.parseString("1 +pi"));
        assertEquals("-2.141592654", miniraknare.parseString("-pi+1"));
    }

    @Test
    public void testHistory() {
        assertEquals("", miniraknare.getNextHistory());
        assertEquals("", miniraknare.getNextHistory());
        assertEquals("", miniraknare.getPrevHistory());
        assertEquals("", miniraknare.getPrevHistory());
        miniraknare.parseString("45");
        assertEquals("45", miniraknare.getNextHistory());
        assertEquals("45", miniraknare.getNextHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        miniraknare.parseString("5+10");
        assertEquals("15", miniraknare.getNextHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        assertEquals("15", miniraknare.getNextHistory());
        assertEquals("15", miniraknare.getNextHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        miniraknare.parseString("7*3");
        assertEquals("15", miniraknare.getPrevHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        assertEquals("45", miniraknare.getPrevHistory());
        assertEquals("15", miniraknare.getNextHistory());
        assertEquals("21", miniraknare.getNextHistory());
        assertEquals("21", miniraknare.getNextHistory());
    }

}

