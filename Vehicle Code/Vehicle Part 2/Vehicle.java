
import java.util.Calendar;
import java.util.GregorianCalendar;

abstract class Vehicle implements Comparable<Vehicle>, Cloneable{
	private String color;
	private String name;
	private String serialNumber;
	private int model;
	private int price;
	private int direction;
	private double speed;
	protected java.util.Scanner input;
	private GregorianCalendar buyingDate;
	
	public Vehicle() {
	}
	
	public Vehicle(
			String name,
			String color,
			int price,
			int model,
			String serialNumber, 
			int direction) {
		this.color = color;
		this.name = name;
		this.serialNumber = serialNumber;
		this.model = model;
		this.price = price;
		this.direction = direction;
		this.speed = 0.0;
		this.buyingDate = new GregorianCalendar();
	}
	
	public void setAllFields() {
		//input = new Scanner(System.in);
		
		System.out.println("Name: ");
		this.name = input.next();
		
		System.out.println("Color: ");
		this.color = input.next();
		
		System.out.println("Price: ");
		this.price = input.nextInt();
		
		System.out.println("Model: ");
		this.model = input.nextInt();
		
		System.out.println("Serial: ");
		this.serialNumber = input.next();
		
	}
	
	// abstract methods
	abstract public void turnLeft(int degrees);
	abstract public void turnRight(int degrees);
	
	// getter functions for all the variables.
	public String getColor() { return this.color;	}
	public String getName() { return this.name;	}
	public String getSerialNumber() { return this.serialNumber;	}
	public int getModel() { return this.model;	}
	public int getPrice() { return this.price;	}
	public int getDirection() { return this.direction;	}
	public double getSpeed() { return this.speed;	}
	public GregorianCalendar getBuyingDate() { return buyingDate; }
	
	// setter methods for all the variables.
	public void setColor(String color) {	this.color = color;	}
	public void setName(String name) { this.name = name; }
	public void setSerialNumber(String serialNum) { this.serialNumber = serialNum;	}
	public void setModel(int model) { this.model = model;	}
	public void setPrice(int price) { this.price = price;	}
	public void setDirection(int dir) { this.direction = dir;	}
	public void setSpeed(double speed) { this.speed = speed;	}
	public void setBuyingDate(GregorianCalendar buyingDate) { this.buyingDate = buyingDate; 	}
	
	public String toString() {
		String info = "Name: "+ this.getName() 
					+ " Color: " + this.getColor()
					+ " Price: " + this.getPrice()
					+ " Model: " + this.getModel()
					+ " Serial: " + this.getSerialNumber()
					+ " Direction: " + this.getDirection()
					+ " Speed: " + this.getSpeed() 
					+ " Buying Date: " + date();
		
		return info;
	}
	
	private String date() {
		String result = "" + this.getBuyingDate().get(Calendar.YEAR) + "-" + (this.getBuyingDate().get(Calendar.MONTH) + 1) + "-" + this.getBuyingDate().get(Calendar.DATE);
		return result;
	}
	
	public int compareTo(Vehicle veh) {
		return this.getPrice() - veh.getPrice();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Vehicle veh = null;
		try {
			veh = (Vehicle) super.clone();
			veh.buyingDate = this.buyingDate;
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return veh;
	}
	
}
