package es.test.jump;

import es.test.jump.commands.*;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class TranslationCommands implements CommandMarker{
    private List<Shape> shapes = new ArrayList<Shape>();
    private String[] parserOptions(String buffer){
        String delims = "[ ]+";
        return buffer.split(delims);
    }

    @CliCommand(value = "circle", help = "add circle shape")
    public String circle(@CliOption(key = {"", "text"}) String text) {
        String[] argument;
        // Check args, etc.
        if (text != null) {
            argument = parserOptions(text);
             Circle circle;
             try {
                 circle = new Circle(argument);
             }catch(Exception e){
                 return e.getMessage();
             }
             shapes.add(circle);
             return circle.toString(shapes.size());
        }
        return "error";
    }

    @CliCommand(value = "rectangle", help = "add rectangle shape")
    public String rectangle(@CliOption(key = {"", "text"}) String text) {
        String[] argument;
        // Check args, etc.
        if (text != null) {
            argument = parserOptions(text);
            Rectangle rectangle;
            try {
                rectangle = new Rectangle(argument);
            }catch(Exception e){
                return e.getMessage();
            }
            shapes.add(rectangle);
            return rectangle.toString(shapes.size());
        }
        return "error";
    }

    @CliCommand(value = "square", help = "add square shape")
    public String square(@CliOption(key = {"", "text"}) String text) {
        String[] argument;
        // Check args, etc.
        if (text != null) {
            argument = parserOptions(text);
            Square square;
            try {
                square = new Square(argument);
            }catch(Exception e){
                return e.getMessage();
            }
            shapes.add(square);
            return square.toString(shapes.size());
        }
        return "error";
    }

    @CliCommand(value = "donut", help = "add donut shape")
    public String donut(@CliOption(key = {"", "text"}) String text) {
        String[] argument;
        // Check args, etc.
        if (text != null) {
            argument = parserOptions(text);
            Donut donut;
            try {
                donut = new Donut(argument);
            }catch(Exception e){
                return e.getMessage();
            }
            shapes.add(donut);
            return donut.toString(shapes.size());
        }
        return "error";
    }

    @CliCommand(value = "triangle", help = "add triangle shape")
    public String triangle(@CliOption(key = {"", "text"}) String text) {
        String[] argument;
        // Check args, etc.
        if (text != null) {
            argument = parserOptions(text);
            Triangle triangle;
            try {
                triangle = new Triangle(argument);
            }catch(Exception e){
                return e.getMessage();
            }
            shapes.add(triangle);
            return triangle.toString(shapes.size());
        }
        return "error";
    }

    @CliCommand(value = "shapes", help = "translate text from one language to another")
    public String shapes(@CliOption(key = {"", "text"}) String text) {
        StringBuffer sb = new StringBuffer();
        String[] argument;
        if (text != null) {
            argument = parserOptions(text);
                Iterator it = shapes.iterator();
                int i = 1;
                while (it.hasNext()) {
                    Shape shape = (Shape)it.next();
                    if (shape.pointIsInside(Double.valueOf(argument[0]), Double.valueOf(argument[1])))
                        sb.append("shape " + i + "\n");
                    i++;
                }
         }
        return sb.toString();
    }
}
