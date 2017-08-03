package es.test.jump;

import es.test.jump.commands.Circle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CircleTest {
    @Test()
    public void radiusNegative() {
        String[] arguments = new String[3];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "-2.1";
        try {
            Circle circle = new Circle(arguments);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Circle radius is negative");
        }
    }
    @Test()
    public void numberArgumentsWrong() {
        String[] arguments = new String[2];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        try {
            Circle circle = new Circle(arguments);
        } catch (Exception e) {
            assertEquals("Circle wrong number of arguments. It must be 3",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentNotDouble() {
        String[] arguments = new String[3];
        arguments[0]= "2.1";
        arguments[1]= "3.1";
        arguments[2]= "2.1";
        try {
            Circle circle = new Circle(arguments);
        } catch (Exception e) {
            assertEquals("Circle one argument is not double",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentEmpty() {
        String[] arguments = new String[3];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "";
        try {
            Circle circle = new Circle(arguments);
        } catch (Exception e) {
            assertEquals("Circle one argument is empty",e.getMessage().toString());
        }
    }

    @Test()
    public void insideCircle() throws Exception{
        String[] arguments = new String[3];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        Circle circle = new Circle(arguments);
        assertTrue(circle.pointIsInside(1.0D,1.0D));
    }

    @Test()
    public void outsideCircle() throws Exception{
        String[] arguments = new String[3];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        Circle circle = new Circle(arguments);
        assertTrue(!circle.pointIsInside(3.0D,3.0D));
    }

    @Test()
    public void goodArguments() throws Exception{
        String[] arguments = new String[3];
        arguments[0]= "2.1";
        arguments[1]= "3.1";
        arguments[2]= "2.1";
        Circle circle = new Circle(arguments);
        assertEquals(circle.toString(1),"=> shape 1: circle with centre at (2.1, 3.1) and radius 2.1");
    }
}

