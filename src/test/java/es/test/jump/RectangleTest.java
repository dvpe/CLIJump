package es.test.jump;

import es.test.jump.commands.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RectangleTest {
    @Test()
    public void widthNegative() {
        String[] arguments = new String[4];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "-2.1";
        arguments[3] = "2.1";
        try {
            Rectangle rectangle = new Rectangle(arguments);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Rectangle width is negative");
        }
    }

    @Test()
    public void lengthNegative() {
        String[] arguments = new String[4];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        arguments[2] = "2.1";
        arguments[3] = "-2.1";
        try {
            Rectangle rectangle = new Rectangle(arguments);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Rectangle heigth is negative");
        }
    }
    @Test()
    public void numberArgumentsWrong() {
        String[] arguments = new String[2];
        arguments[0] = "2.1";
        arguments[1] = "3.1";
        try {
            Rectangle rectangle = new Rectangle(arguments);
        } catch (Exception e) {
            assertEquals("Rectangle wrong number of arguments. It must be 4",e.getMessage().toString());
        }
    }

    @Test()
    public void argumentNotDouble() {
        String[] arguments = new String[4];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "Text";
        arguments[3] = "3.0";
        try {
            Rectangle rectangle = new Rectangle(arguments);
        } catch (Exception e) {
            assertEquals("Rectangle one argument is not double",e.getMessage().toString());
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
            Rectangle rectangle = new Rectangle(arguments);
        } catch (Exception e) {
            assertEquals("Rectangle one argument is empty",e.getMessage().toString());
        }
    }

    @Test()
    public void insideRectangle() throws Exception{
        String[] arguments = new String[4];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        arguments[3] = "3.0";
        Rectangle rectangle = new Rectangle(arguments);
        assertTrue(rectangle.pointIsInside(2.0D,3.0D));
    }

    @Test()
    public void outsideRectangle() throws Exception{
        String[] arguments = new String[4];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        arguments[3] = "3.0";
        Rectangle rectangle = new Rectangle(arguments);
        assertTrue(!rectangle.pointIsInside(4.0D,2.0D));
    }

    @Test()
    public void goodArguments() throws Exception{
        String[] arguments = new String[4];
        arguments[0] = "0.0";
        arguments[1] = "0.0";
        arguments[2] = "2.0";
        arguments[3] = "3.0";
        Rectangle rectangle = new Rectangle(arguments);
        assertEquals(rectangle.toString(1),"=> shape 1: rectangle with corner at (0.0, 0.0), width 2.0 and heigth 3.0");
    }
}

