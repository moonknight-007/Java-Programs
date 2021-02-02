import java.util.Scanner;

public class Bicycle extends Vehicle{
	private int gear;
	Bicycle(){
		
	}
	Bicycle(String name,
			String color,
			int price,
			int model,
			String serialNum,
			int dir,
			int gears){
		super(name, color, model, price, serialNum, dir);
		this.gear = gears;
	}
	public void setAllFields() {
		input = new Scanner(System.in);
		
		System.out.print("Name: ");
		setName(input.next());
		
		System.out.print("Color: ");
		setColor(input.next());
		
		System.out.print("Price: ");
		setPrice(input.nextInt());
		
		System.out.print("Model: ");
		setModel(input.nextInt());
		
		System.out.print("Serial #: ");
		setSerialNumber(input.next());
		
		System.out.print("Gears: ");
		this.gear =  input.nextInt();
	}
	
	public void turnRight(int degrees) {
		System.out.println("bike has turned right by " + degrees);
	}
	public void turnLeft(int degrees) {
		System.out.println("bike has turned left by " + degrees);
	}
	public void setGear(int gear) {
		this.gear = gear;
	}
	public int getGear() {
		return gear;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " Gears: " + gear;
	}
}
