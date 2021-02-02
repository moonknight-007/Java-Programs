import java.util.Calendar;
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
		
		setBuyingDate(Calendar.getInstance());
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
		return super.toString() + " Gears: " + gear;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Bicycle bicycle = null;
		bicycle = (Bicycle) super.clone();
		return bicycle;
	}
	
	@Override
	public void accelerate(int speedFactor){
		double sp = 0;
		if(getSpeed() == 0) {
			sp = 0.3 * speedFactor;
		}else {
			sp = getSpeed() * 0.5 * speedFactor;
		}
		sp = sp < Driveable.MAX_SPEED_BIKE ? sp : Driveable.MAX_SPEED_BIKE;
		setSpeed(sp);
		System.out.println("Speed of bike is " + sp + " km/h after using acclerator");
	}
	
	@Override
	public void breaks(int speedFactor) {
		setSpeed(getSpeed()/(0.5 * speedFactor));
		System.out.println("Speed of bicycle is " + getSpeed() + " km/h after using breaks");
	}
}
