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
             Circle circle = new Circle(argument);
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
            Rectangle rectangle = new Rectangle(argument);
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
            Square square = new Square(argument);
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
            Donut donut = new Donut(argument);
            shapes.add(donut);
            return donut.toString(shapes.size());
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
