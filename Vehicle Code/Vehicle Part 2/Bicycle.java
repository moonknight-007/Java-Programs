import java.util.Scanner;

public class Bicycle extends Vehicle{
	private int gears;
	Bicycle(){
		this.setAllFields();
	}
	Bicycle( 
		String name,
		String color,
		int model,
		int price,
		String serialNumber,
		int direction,
		int gears){
		super(name, color, model, price, serialNumber, direction);
		this.gears = gears;
	}
	public void turnRight(int degrees) {
		System.out.println("bike has turned right by " + degrees);
	}
	public void turnLeft(int degrees) {
		System.out.println("bike has turned left by " + degrees);
	}
	public void setGears(int gears) {
		this.gears = gears;
	}
	public int getGears() {
		return this.gears;
	}
	public void setAllFields() {
		input = new Scanner(System.in);
		System.out.println("Input bike data ");
		super.setAllFields();
		
		System.out.print("Gears: ");
		this.gears = input.nextInt();
		input.close();
	}
	public String toString() {
		String info = super.toString()
					+ " Gears: " + this.getGears();
		return info;
	}
	public Object clone() throws CloneNotSupportedException{
		Bicycle bicycle = null;
		try {
			bicycle = (Bicycle) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return bicycle;
	}
}
