package es.test.jump.commands;

public abstract class Shape {
    public String toString(int pos) {
        return "=> shape " + pos + ": ";
    }
    abstract void checkRequirements(String[] arguments)  throws Exception;
    abstract public boolean pointIsInside(double x, double y);
}
