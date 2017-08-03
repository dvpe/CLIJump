package es.test.jump.commands;

public class Square extends Shape{
    private Double x;
    private Double y;
    private Double length;

    public Square(String[] arguments) throws Exception{
        checkRequirements(arguments);
        this.x = Double.parseDouble(arguments[0]);
        this.y = Double.parseDouble(arguments[1]);
        this.length = Double.parseDouble(arguments[2]);
    }

    @Override
    void checkRequirements(String[] arguments) throws Exception{
        if (arguments.length != 3)
            throw new Exception("Square wrong number of arguments. It must be 3");
        for(int i=0;i<3;i++){
            if (arguments[i].isEmpty())
                throw new Exception("Square one argument is empty");
            try {
                Double.parseDouble(arguments[i]);
            }catch(NumberFormatException e){
                throw new Exception("Square one argument is not double");
            }
        }
        if (Double.parseDouble(arguments[2]) < 0)
            throw new Exception("Square length is negative");

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
