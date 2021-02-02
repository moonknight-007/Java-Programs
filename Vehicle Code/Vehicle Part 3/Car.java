import java.util.Calendar;
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
		
		setBuyingDate(Calendar.getInstance());
		
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
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Car car = null;
		car = (Car) super.clone();
		return car;
	}
	
	@Override
	public void accelerate(int speedFactor){
		double sp;
		if(getSpeed() == 0) {
			sp = 0.5 * speedFactor;
		}else {
			sp = getSpeed() * speedFactor;
		}
		sp = sp < Driveable.MAX_SPEED_CAR ? sp : Driveable.MAX_SPEED_CAR;
		setSpeed(sp);
		System.out.println("Speed of car after using acclerator: " + sp + " km/h");
	}
	
	@Override
	public void breaks(int speedFactor) {
		setSpeed(getSpeed()/speedFactor);
		System.out.println("speed of car after using breaks: " + getSpeed() + " km/h");
	}
}
