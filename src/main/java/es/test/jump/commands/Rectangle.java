package es.test.jump.commands;

public class Rectangle extends Shape{
    private Double x;
    private Double y;
    private Double width;
    private Double heigth;

    public Rectangle(String[] arguments) throws Exception{
        checkRequirements(arguments);
        this.x = Double.parseDouble(arguments[0]);
        this.y = Double.parseDouble(arguments[1]);
        this.width = Double.parseDouble(arguments[2]);
        this.heigth = Double.parseDouble(arguments[3]);
    }

    @Override
    void checkRequirements(String[] arguments) throws Exception{
        if (arguments.length != 4)
            throw new Exception("Rectangle wrong number of arguments. It must be 4");
        for(int i=0;i<4;i++){
            if (arguments[i].isEmpty())
                throw new Exception("Rectangle one argument is empty");
            try {
                Double.parseDouble(arguments[i]);
            }catch(NumberFormatException e){
                throw new Exception("Rectangle one argument is not double");
            }
        }
        if (Double.parseDouble(arguments[2]) < 0)
            throw new Exception("Rectangle width is negative");
        if (Double.parseDouble(arguments[3]) < 0)
            throw new Exception("Rectangle heigth is negative");
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
