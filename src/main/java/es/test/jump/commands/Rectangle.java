package es.test.jump.commands;

public class Rectangle extends Shape{
    private Double x;
    private Double y;
    private Double width;
    private Double heigth;

    public Rectangle(String[] arguments) {
        if (checkRequirements(arguments)) {
            this.x = Double.parseDouble(arguments[0]);
            this.y = Double.parseDouble(arguments[1]);
            this.width = Double.parseDouble(arguments[2]);
            this.heigth = Double.parseDouble(arguments[3]);
        }
    }

    @Override
    boolean checkRequirements(String[] arguments) {
        if ((arguments.length != 4) || (Double.parseDouble(arguments[2]) < 0) || (Double.parseDouble(arguments[3]) < 0))
            return false;
        return true;
    }

    @Override
    public boolean pointIsInside(double x, double y) {
        return (x >= this.getX() && y >= this.getX() && (x <= this.getX() + this.getWidth()) && (y <= this.getY() + this.getHeigth()));
    }

    public String toString(int pos) {
        return super.toString(pos) + "rectangle with corner at (" + x + ", " + y + "), width " + width + " and heigth " + heigth ;
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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeigth() {
        return heigth;
    }

    public void setHeigth(Double heigth) {
        this.heigth = heigth;
    }
}
