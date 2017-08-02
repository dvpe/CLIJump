package es.test.jump.commands;

public abstract class Shape {
    public String toString(int pos) {
        return "=> shape " + pos + ": ";
    }
    abstract boolean checkRequirements(String[] arguments);
    abstract public boolean pointIsInside(double x, double y);
}
