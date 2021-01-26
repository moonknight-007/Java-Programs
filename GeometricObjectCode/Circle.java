package GeometricObjectCode;

public class Circle extends GeometricObject {
    private double radius;

    //Constructors
    public Circle() {
    	this(1.0);
    }
    public Circle(double radius) {
        this(radius, "green", true);
    }
    public Circle(double radius, String color, boolean filled) {
        super(color,filled);
    	this.radius = radius;
    }

    //Getter and setters
    public double getRadius() {
        return radius;
    }
    public double getDiameter() {
        return 2 * radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //Abstract classes implemented
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public boolean equals(Object o) {
    	if(o instanceof Circle) {
    		return ((Circle) o).getRadius() == this.getRadius();
    	}
        return false;
    }

    //Override toString
    @Override
    public String toString() {
        return "circle:\n" + "Radius: " + getRadius() + "\n" + super.toString();
    }

}
