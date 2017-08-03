package es.test.jump;

import es.test.jump.commands.Donut;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DonutTest {
    @Test()
    public void radiusMinNegative() {
        String[] arguments = new String[4];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "-2.1";
        arguments[3] = "2.1";
        try {
            Donut donut = new Donut(arguments);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Donut radiusMin negative");
        }
    }

    @Test()
    public void radiusMaxNegative() {
        String[] arguments = new String[4];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "2.1";
        arguments[3] = "-2.1";
        try {
            Donut donut = new Donut(arguments);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Donut radiusMax negative");
        }
    }

    @Test()
    public void numberArgumentsWrong() {
        String[] arguments = new String[2];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        try {
            Donut donut = new Donut(arguments);
        } catch (Exception e) {
            assertEquals("Donut wrong number of arguments. It must be 4",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentEmpty() {
        String[] arguments = new String[4];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "";
        arguments[3] = "";
        try {
            Donut donut = new Donut(arguments);
        } catch (Exception e) {
            assertEquals("Donut one argument is empty",e.getMessage().toString());
        }
    }
    @Test()
    public void argumentNotDouble() {
        String[] arguments = new String[4];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "Text";
        arguments[3] = "2.0";
        try {
            Donut donut = new Donut(arguments);
        } catch (Exception e) {
            assertEquals("Donut one argument is not double",e.getMessage().toString());
        }
    }

    @Test()
    public void radiusMaxSmaller() {
        String[] arguments = new String[4];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "5.0";
        arguments[3] = "2.0";
        try {
            Donut donut = new Donut(arguments);
        } catch (Exception e) {
            assertEquals("Donut radiusMax smaller than radiusMin",e.getMessage().toString());
        }
    }

    @Test()
    public void insideDonut() throws Exception{
        String[] arguments = new String[4];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        arguments[3] = "4.0";
        Donut donut = new Donut(arguments);
        assertTrue(donut.pointIsInside(3.0D,0.0D));
    }

    @Test()
    public void outsideDonut() throws Exception{
        String[] arguments = new String[4];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        arguments[3] = "4.0";
        Donut donut = new Donut(arguments);
        assertTrue(!donut.pointIsInside(5.0D,0.0D));
        assertTrue(!donut.pointIsInside(1.0D,0.0D));
    }

    @Test()
    public void goodArguments() throws Exception{
        String[] arguments = new String[4];
        arguments[0]= "2.1";
        arguments[1]= "3.1";
        arguments[2]= "2.1";
        arguments[3] = "4.0";
        Donut donut = new Donut(arguments);
        assertEquals(donut.toString(1),"=> shape 1: donut with centre at (2.1, 3.1), radiusMin 2.1 and radiusMax 4.0");
    }
}

