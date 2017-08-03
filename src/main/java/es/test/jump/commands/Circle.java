package es.test.jump.commands;

public class Circle extends Shape{
    private Double x;
    private Double y;
    private Double radius;

    public Circle(String[] arguments) throws Exception {
        checkRequirements(arguments);
        this.x = Double.parseDouble(arguments[0]);
        this.y = Double.parseDouble(arguments[1]);
        this.radius = Double.parseDouble(arguments[2]);
    }

    @Override
    void checkRequirements(String[] arguments) throws Exception {
        if (arguments.length != 3)
            throw new Exception("Circle wrong number of arguments. It must be 3");
        for(int i=0;i<3;i++){
            if (arguments[i].isEmpty())
                throw new Exception("Circle one argument is empty");
            try {
                Double.parseDouble(arguments[i]);
            }catch(NumberFormatException e){
                throw new Exception("Circle one argument is not double");
            }
        }
        if (Double.parseDouble(arguments[2]) < 0)
            throw new Exception("Circle radius is negative");
    }

    @Override
    public boolean pointIsInside(double x, double y) {
        return Math.hypot(x-this.getX(),y-this.getY()) <= this.getRadius();
    }

    public String toString(int pos) {
        return super.toString(pos) + "circle with centre at (" + x + ", " + y + ") and radius " + radius ;
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

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
