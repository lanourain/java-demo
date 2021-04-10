package Polygon;

public class Point {
    private double x;

    private double y;

    public Point(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point() {
        super();
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public static Point valueOf(double x,double y){
        return new Point(x, y);
    }
    public static Point valueOf(String x,String y){
        return new Point(Double.valueOf(x),Double.valueOf(y));
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
    
    

}
