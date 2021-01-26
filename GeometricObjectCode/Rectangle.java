package GeometricObjectCode;

public class Rectangle extends GeometricObject {
    private double width;
    private double height;

    //Constructors
    public Rectangle() {
    }
    public Rectangle(double recSide) {
        this(recSide,recSide);
    }
    public Rectangle(double width, double height) {
        this(width, height, "Red", false);
    }
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color,filled);
    	this.width = width;
        this.height = height;
    }

    //Getter and setters
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double Height) {
        this.height = Height;
    }
    
    //Abstract classes implemented
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object o) {
    	if(o instanceof Rectangle) {
    		Rectangle obj = (Rectangle) o;
    		return (obj.getWidth() == this.getWidth() && obj.getHeight() == this.getHeight());
    	}
        return false;
    }

    //Override toString
    @Override
    public String toString() {
        return "Rectangle:\n" + "Width: " + getWidth() + " Height: " + getHeight() + "\n" + super.toString();
    }
}

