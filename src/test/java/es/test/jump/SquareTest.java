package es.test.jump;

import es.test.jump.commands.Rectangle;
import es.test.jump.commands.Square;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SquareTest {
    @Test()
    public void lengthNegative() {
        String[] arguments = new String[3];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "-2.1";
        try {
            Square square = new Square(arguments);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Square length is negative");
        }
    }
    @Test()
    public void numberArgumentsWrong() {
        String[] arguments = new String[2];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        try {
            Square square = new Square(arguments);
        } catch (Exception e) {
            assertEquals("Square wrong number of arguments. It must be 3",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentEmpty() {
        String[] arguments = new String[3];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "";
        try {
            Square square = new Square(arguments);
        } catch (Exception e) {
            assertEquals("Square one argument is empty",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentNotDouble() {
        String[] arguments = new String[3];
        arguments[0]= "2.1";
        arguments[1]= "Text";
        arguments[2]= "2.1";
        try {
            Square square = new Square(arguments);
        } catch (Exception e) {
            assertEquals("Square one argument is not double",e.getMessage().toString());
        }
    }

    @Test()
    public void insideSquare() throws Exception{
        String[] arguments = new String[3];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        Square square = new Square(arguments);
        assertTrue(square.pointIsInside(1.0D,1.0D));
    }

    @Test()
    public void outsideSquare() throws Exception{
        String[] arguments = new String[3];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        Square square = new Square(arguments);
        assertTrue(!square.pointIsInside(3.0D,0.0D));
    }

    @Test()
    public void goodArguments() throws Exception{
        String[] arguments = new String[3];
        arguments[0]= "2.1";
        arguments[1]= "3.1";
        arguments[2]= "2.1";
        Square square = new Square(arguments);
        assertEquals(square.toString(1),"=> shape 1: square with corner at (2.1, 3.1) and length 2.1");
    }
}

