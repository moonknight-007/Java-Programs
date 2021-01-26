package GeometricObjectCode;

public class Triangle extends GeometricObject {
    private double side1, side2, side3;

    //Constructors
    Triangle() {
    	this(3.0);
    }
    Triangle(double side) {
        this(side, side, side);
    }
    Triangle(double side1, double side2, double side3) {
        this(side1, side2, side3, "brown", true);
    }

    Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color,filled);
    	setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    
    //Getter and setters
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setFilled(boolean fill) {
    	this.setFilled(fill);
    }

    public boolean checkLegality() {
        if (getArea() > 0) {
            return getPerimeter() > 0;
        }
        return false;
    }

    //Abstract classes implemented
    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt((s * (s - getSide1()) * (s - getSide2()) * (s - getSide3())));
    }

    @Override
    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Triangle) {
            Triangle t = (Triangle) o;
            return (side1 == t.side1 && side2 == t.side2 && side3 == t.side3);
        }
        return false;
    }

    //Override toString
    @Override
    public String toString() {
        return "triangle:\n" + "Sides: " +
                getSide1() + ", " + getSide2() + ", " + getSide3() + "\n" + super.toString();
    }

}