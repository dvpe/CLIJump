package es.test.jump;

import es.test.jump.commands.Circle;
import es.test.jump.commands.Triangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TriangleTest {
    @Test()
    public void numberArgumentsWrong() {
        String[] arguments = new String[2];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        try {
            Triangle triangle = new Triangle(arguments);
        } catch (Exception e) {
            assertEquals("Triangle wrong number of arguments. It must be 6",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentEmpty() {
        String[] arguments = new String[6];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "";
        arguments[3] = "";
        arguments[4] = "";
        arguments[5] = "";
        try {
            Triangle triangle = new Triangle(arguments);
        } catch (Exception e) {
            assertEquals("Triangle one argument is empty",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentNotDouble() {
        String[] arguments = new String[6];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "5.0";
        arguments[3] = "Text";
        arguments[4] = "2.0";
        arguments[5] = "6.0";
        try {
            Triangle triangle = new Triangle(arguments);
        } catch (Exception e) {
            assertEquals("Triangle one argument is not double",e.getMessage().toString());
        }
    }

    @Test()
    public void insideTriangle() throws Exception{
        String[] arguments = new String[6];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "5.0";
        arguments[3] = "0.0";
        arguments[4] = "2.0";
        arguments[5] = "6.0";
        Triangle triangle = new Triangle(arguments);
        assertTrue(triangle.pointIsInside(1.0D,1.0D));
    }

    @Test()
    public void outsideTriangle() throws Exception{
        String[] arguments = new String[6];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "5.0";
        arguments[3] = "0.0";
        arguments[4] = "2.0";
        arguments[5] = "6.0";
        Triangle triangle = new Triangle(arguments);
        assertTrue(!triangle.pointIsInside(6.0D,1.0D));
    }

    @Test()
    public void goodArguments() throws Exception{
        String[] arguments = new String[6];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "5.0";
        arguments[3] = "0.0";
        arguments[4] = "2.0";
        arguments[5] = "6.0";
        Triangle triangle = new Triangle(arguments);
        assertEquals(triangle.toString(1),"=> shape 1: triangle with corner at (0.0, 0.0), (5.0, 0.0), (2.0, 6.0)");
    }
}

