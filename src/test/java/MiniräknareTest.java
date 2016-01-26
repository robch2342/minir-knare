
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class MiniräknareTest {

    private Miniräknare miniräknare = new Miniräknare();

    @Rule
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
        }

    @Test
    public void testDivision() throws Exception {
        double a = 10;
        double b = 2;

        assertEquals("Testar division", 5, miniräknare.division(a, b), 0);
    }

    @Test
    public void testKvadratroten() throws Exception{
        double a = 25;

        assertEquals("Testar kvadratroten",5, miniräknare.kvadratroten(a),0);
    }

    @Test
    public void testRaknesattMulti() throws Exception{
        String raknesatt = "m";

        assertEquals("teststar räknesättet", "multiplikation", miniräknare.raknesatt(raknesatt));
    }

    @Test
    public void testRaknesattSub() throws Exception{
        String raknesatt = "s";

        assertEquals("teststar räknesättet", "subtraktion", miniräknare.raknesatt(raknesatt));
    }

    @Test
    public void testRaknesattAdd() throws Exception{
        String raknesatt = "a";

        assertEquals("teststar räknesättet", "addition", miniräknare.raknesatt(raknesatt));
    }

    @Test
    public void testRaknesattDiv() throws Exception{
        String raknesatt = "d";

        assertEquals("teststar räknesättet", "division", miniräknare.raknesatt(raknesatt));
    }

    @Test
    public void testNoAvsluta(){
        //passes
    }

    @Test
    public void testAvsluta(){
        exit.expectSystemExit();
        miniräknare.avsluta();
    }
}

