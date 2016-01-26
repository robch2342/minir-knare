import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiniräknareTest {

    private Miniräknare miniräknare = new Miniräknare();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddition() throws Exception{
        double a = 5;
        double b = 5;

        assertEquals("Testar addition", 10, miniräknare.addition(a, b),0);
    }

    @Test
    public void testPi() throws Exception{
        double pi = 3.1415;

        assertEquals("Testar pi", pi, miniräknare.pi(), 0);
    }

    @Test
    public void testMultiplikation() throws Exception{
        double a = 10;
        double b = 10;

        assertEquals("Testar multiplikation", 100, miniräknare.multiplikation(a, b), 0);
        }
    }
