package es.test.jump.commands;

public class Square extends Shape{
    private Double x;
    private Double y;
    private Double length;

    public Square(String[] arguments) {
        if (checkRequirements(arguments)) {
            this.x = Double.parseDouble(arguments[0]);
            this.y = Double.parseDouble(arguments[1]);
            this.length = Double.parseDouble(arguments[2]);
        }
    }

    @Override
    boolean checkRequirements(String[] arguments) {
        if ((arguments.length != 3) || (Double.parseDouble(arguments[2]) < 0))
            return false;
        return true;
    }

    @Override
    public boolean pointIsInside(double x, double y) {
        return (x >= this.getX() && y >= this.getX() && (x <= this.getX() + this.getLength()) && (y <= this.getY() + this.getLength()));
    }

    public String toString(int pos) {
        return super.toString(pos) + "square with corner at (" + x + ", " + y + ") and length " + length ;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
