package es.test.jump.commands;

public class Triangle extends Shape{
    private Double x1;
    private Double y1;
    private Double x2;
    private Double y2;
    private Double x3;
    private Double y3;

    public Triangle(String[] arguments) {
        if (checkRequirements(arguments)) {
            this.x1 = Double.parseDouble(arguments[0]);
            this.y1 = Double.parseDouble(arguments[1]);
            this.x2 = Double.parseDouble(arguments[2]);
            this.y2 = Double.parseDouble(arguments[3]);
            this.x3 = Double.parseDouble(arguments[4]);
            this.y3 = Double.parseDouble(arguments[5]);
        }
    }

    @Override
    boolean checkRequirements(String[] arguments) {
        if ((arguments.length != 6))
            return false;
        return true;
    }

    @Override
    public boolean pointIsInside(double x, double y) {
        //A --> x1,y1
        //B --> x2,y2
        //C --> x3,y3
        double ABC = Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
        double ABP = Math.abs((x1 * (y2 - y) + x2 * (y - y1) + x * (y1 - y2))/2.0);
        double APC = Math.abs((x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y))/2.0);
        double PBC = Math.abs((x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2))/2.0);

        return (ABP + APC + PBC == ABC);
    }

    public String toString(int pos) {
        return super.toString(pos) + "triangle with corner at (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")";
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getY1() {
        return y1;
    }

    public void setY1(Double y1) {
        this.y1 = y1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public Double getY2() {
        return y2;
    }

    public void setY2(Double y2) {
        this.y2 = y2;
    }

    public Double getX3() {
        return x3;
    }

    public void setX3(Double x3) {
        this.x3 = x3;
    }

    public Double getY3() {
        return y3;
    }

    public void setY3(Double y3) {
        this.y3 = y3;
    }
}
