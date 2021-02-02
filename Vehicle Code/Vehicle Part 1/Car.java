import java.util.Scanner;

public class Car extends Vehicle {
	private int power;
	Car(){
		
	}
	Car(String name,
		String color,
		int price,
		int model,
		String serialNum,
		int dir,
		int power){
		super(name, color, model, price, serialNum, dir);
		this.power = power;
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
		
		System.out.print("power: ");
		this.power =  input.nextInt();
	}
	
	public void turnRight(int degrees) {
		if(degrees > 0 && degrees < 360) {
			setDirection( (getDirection() + degrees)  % 360);
		}
	}
	public void turnLeft(int degrees) {
		if(degrees > 0 && degrees < 360) {
			if( getDirection() - degrees > 0 ) {
				setDirection(getDirection() - degrees);
			}else {
				setDirection(getDirection() - degrees + 360);
			}
		}
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPower() {
		return power;
	}
	@Override
	public String toString() {
		String info = super.toString() + " Power: " + power;
		return info;
	}
}
