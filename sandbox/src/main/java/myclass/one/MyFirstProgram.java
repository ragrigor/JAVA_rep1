package myclass.one;

public class MyFirstProgram{
	public static void main (String[] args) {
		

		Point p1 = new Point();
		p1.x = 2;
		p1.y = 3;

		Point p2 = new Point();
		p2.x = 5;
		p2.y = 10;
		double d = distance(p1, p2);
		System.out.println(d);
	}

	public static double distance(Point p1, Point p2){
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));

	}
}


