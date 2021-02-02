package GeometricObjectCode;
import java.util.GregorianCalendar;

abstract class GeometricObject implements Comparable<GeometricObject>{
	
	private String color;
	private boolean filled;
	private GregorianCalendar dateCreated;
	
	public GeometricObject() {	
	}

	GeometricObject(String color, boolean isfilled){
		this.color = color;
		this.filled = isfilled;
		this.dateCreated = new GregorianCalendar();
	}
	
	public abstract boolean equals(Object other);
	public abstract double getArea();
	public abstract double getPerimeter();
	
	@Override
	public int compareTo(GeometricObject o) {
		return this.getArea() - o.getArea() > 0 ? 1 : -1;
		
	}
	
	public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
		return obj1.compareTo(obj2) > 0 ? obj1 : obj2;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public String getDateCreated() {
		int month = dateCreated.get(GregorianCalendar.MONTH) + 1;  
		int date = dateCreated.get(GregorianCalendar.DATE);
		int year = dateCreated.get(GregorianCalendar.YEAR);
		return String.format("%02d-%02d-%d", date, month, year);
//		return "" + date + "-" + month + "-" + year;
	}

	@Override
	public String toString() {
		String str = "Color: " + color + " isFilled: " + filled + " date created: " + getDateCreated(); 
		return str;
	}
}
