
public abstract class Vehicle {
	private String color;
	private String name;
	private String serialNumber;
	private int model;
	private int price;
	private int direction;
	private double speed;
	protected java.util.Scanner input;
	
	Vehicle(){
		
	}
	
	Vehicle(String name,
			String color,
			int model,
			int price,
			String serialNum,
			int direction){
		this.name = name;
		this.color = color;
		this.model = model;
		this.price = price;
		this.direction = direction;
		this.serialNumber = serialNum;
		this.speed = 0.0;
	}
	
	public void setAllFields() {
		System.out.print("Name: ");
		this.name = input.next();
		
		System.out.print("Color: ");
		this.color = input.next();
		
		System.out.print("Price: ");
		this.price = input.nextInt();
		
		System.out.print("Model: ");
		this.model = input.nextInt();
		
		System.out.print("Serial #: ");
		this.serialNumber = input.next();
	}
	
	public abstract void turnLeft(int degrees);
	public abstract void turnRight(int degrees);
	
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public int getPrice() {
		return price;
	}
	public int getModel() {
		return model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public int getDirection() {
		return direction;
	}
	public double getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		String info = "Name: " + getName()
					+ " Color: " + this.color
					+ " Price: " + getPrice()
					+ " Model: " + getModel()
					+ " Serial #: " + getSerialNumber()
					+ " Direction: " + this.direction
					+ " Speed: " + getSpeed();
		return info;
	}
}
