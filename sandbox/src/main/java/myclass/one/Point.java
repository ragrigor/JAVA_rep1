package myclass.one;


public class Point {
    public double x;
    public double y;




    public Point(double x1, double y1) {
        x = x1;
        y = y1;

    }
    public double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));

    }

}
