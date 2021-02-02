package GeometricObjectCode;

public class GeometricObjectTest {

	public static void main(String[] args) {
		Circle c1 = new Circle(2.0, "brown", false);
		Circle c2 = new Circle(10.0, "black", true);
		
		Circle bigCircle = c1.compareTo(c2) > 0 ? c1 : c2;
		print("The biggest " + bigCircle.toString() + "\n\n");
		
		Rectangle r1 = new Rectangle(10, 20, "Green", true);
		Rectangle r2 = new Rectangle(20, 10, "Blue", false);
		
		Rectangle bigRectangle = r1.compareTo(r2) > 0 ? r1 :r2;
		print("The biggest " + bigRectangle.toString() + "\n\n");
		
		Triangle t1 = new Triangle(10, 20, 25, "Green", true);
		Triangle t2 = new Triangle(20, 10, 20, "white", true);
		
		Triangle bigTriangle = (Triangle) GeometricObject.max(t1, t2);
		print("The biggest " + bigTriangle.toString() + "\n\n");
		
		GeometricObject biggestShape = GeometricObject.max(bigRectangle, GeometricObject.max(bigCircle, bigTriangle));
		print("The biggest Shape: " + biggestShape.toString());
	}

	public static void print(String str) {
		System.out.println(str);
	}
}
