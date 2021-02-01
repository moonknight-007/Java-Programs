
import java.util.Scanner;

public class Car extends Vehicle{
	private int power;
	Car(){
		this.setAllFields();
	}
	Car( 
		String name,
		String serialNumber,
		int model,
		int price,
		String color,
		int direction,
		int power){
		super(name, serialNumber, model, price, color, direction);
		this.power = power;
	}
	
	public void setAllFields() {
		input = new Scanner(System.in);
		System.out.println("Input car data ");
		super.setAllFields();
		
		System.out.print("Power: ");
		this.power = input.nextInt();
		input.close();
	}
	public void turnRight(int degrees) {
		int dir;
		if((degrees >= 0 && degrees < 360)) {
			dir = this.getDirection() + degrees;  
			this.setDirection(dir%360);
		}
	}
	public void turnLeft(int degrees) {
		int dir;
		if((degrees >= 0 && degrees < 360)) {
			dir = this.getDirection() - degrees;
			this.setDirection(dir > 0 ? dir : dir + 360);
		}
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPower() {
		return this.power;
	}
	public String toString() {
		//System.out.println("toString: Car");
		String info = super.toString() + " Power: " + this.getPower();

		return info;
	}
	public Object clone() throws CloneNotSupportedException{
		Car car = null;
		try {
			car = (Car) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return car;
	}
}

