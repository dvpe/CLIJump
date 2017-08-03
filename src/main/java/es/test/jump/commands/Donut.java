package es.test.jump.commands;

public class Donut extends Shape{
    private Double x;
    private Double y;
    private Double radiusMin;
    private Double radiusMax;

    public Donut(String[] arguments) throws Exception {
        checkRequirements(arguments);
        this.x = Double.parseDouble(arguments[0]);
        this.y = Double.parseDouble(arguments[1]);
        this.radiusMin = Double.parseDouble(arguments[2]);
        this.radiusMax = Double.parseDouble(arguments[3]);
    }

    @Override
    void checkRequirements(String[] arguments) throws Exception {
        if (arguments.length != 4)
            throw new Exception("Donut wrong number of arguments. It must be 4");
        for(int i=0;i<4;i++){
            if (arguments[i].isEmpty())
                throw new Exception("Donut one argument is empty");
            try {
                Double.parseDouble(arguments[i]);
            }catch(NumberFormatException e){
                throw new Exception("Donut one argument is not double");
            }
        }
        if (Double.parseDouble(arguments[2]) < 0)
            throw new Exception("Donut radiusMin negative");
        if (Double.parseDouble(arguments[3]) < 0)
            throw new Exception("Donut radiusMax negative");
        if (Double.parseDouble(arguments[2]) > Double.parseDouble(arguments[3]))
            throw new Exception("Donut radiusMax smaller than radiusMin");
    }

    @Override
    public boolean pointIsInside(double x, double y) {
        double hypot = Math.hypot(x-this.getX(),y-this.getY());
        return hypot <= this.getRadiusMax() &&  hypot >= this.getRadiusMin();
    }

    public String toString(int pos) {
        return super.toString(pos) + "donut with centre at (" + x + ", " + y + "), radiusMin " + radiusMin + " and radiusMax " + radiusMax;
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

    public Double getRadiusMin() {
        return radiusMin;
    }

    public void setRadiusMin(Double radiusMin) {
        this.radiusMin = radiusMin;
    }

    public Double getRadiusMax() {
        return radiusMax;
    }

    public void setRadiusMax(Double radiusMax) {
        this.radiusMax = radiusMax;
    }
}
