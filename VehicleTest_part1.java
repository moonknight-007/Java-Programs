// Vehicle part1
package vehicle;

import java.util.*;
import java.io.*;


abstract class Vehicle{
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
			String serialNumber,
			int direction){
		this.name = name;
		this.color = color;
		this.model = model;
		this.price = price;
		this.direction = direction;
		this.serialNumber = serialNumber;
		this.speed = 0.0;
	}
	public void setAllFields() {
		input = new Scanner(System.in);
		
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
	public void setSerialNumber(String snum) {
		this.serialNumber = snum;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public String getName() {
		return this.name;
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

class Car extends Vehicle{
	private int power;
	Car(){
		setAllFields();
	}
	Car(String name,
		String color,
		int price,
		int model,
		String serialNum,
		int dir,
		int pwr){
		super(name, color, model, price, serialNum, dir);
		this.power = pwr; 
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
		return this.power;
	}
	
	public String toString() {
		String info = super.toString() + " Power: " + this.power;
		return info;
	}
	
}

class Bicycle extends Vehicle{
	private int gears;
	Bicycle(){
		setAllFields();
	}
	Bicycle(String name,
			String color,
			int price,
			int year,
			String serialNum,
			int direction,
			int gears){
		super(name, color, year, price, serialNum, direction);
		this.gears = gears;
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
		this.gears =  input.nextInt();
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
		return gears;
	}
	public String toString() {
		String info = super.toString() + " Gears: " + this.gears;
		return info;
	}
}


public class VehicleTest {
  public static void main(String[] args) {
	  VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    } catch(IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    } catch(CloneNotSupportedException e) {
      System.out.println("CloneNotSupportedException");
      System.exit(1);
    }
  }

  private void menuLoop() throws IOException, CloneNotSupportedException {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    Vehicle vehicle;

    arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
    arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));

    while(true) {
      System.out.println("1...................................New car");
      System.out.println("2...............................New bicycle");
      System.out.println("3......................Find vehicle by name");
      System.out.println("4..............Show data about all vehicles");
      System.out.println("5.......Change direction of a given vehicle");
      System.out.println("6..............................Exit program");
      System.out.println(".............................Your choice?");
      int choice = scan.nextInt();

      String name; // to store the name of the vehicle
      int index;	// to store the index of the vehicle in arrayList.
      char dir;	// to store the direction of turn.
      int degrees; // to store the degrees by which we have to turn.
      
      switch (choice) {
      case 1:
        //adding new Car to arrayList
    	  arr.add(new Car());
    	  break;
      case 2:
    	  // adding new Bicycle to arrayList
    	  arr.add(new Bicycle());
    	  break;
      case 3:
    	  System.out.print("name of vehicle you want to search: ");
	        name = scan.next();
	        
	        // finding vehicle in the arrayList
	        index = 0;
	        while(true) {
	        	if(index == arr.size()) {
	        		break;
	        	}
	        	if(arr.get(index).getName().equals(name)) {
	        		break;
	        	}
	        	index++;
	        }
	    	
	        // if vehicle is present: print its details.
	        if(index != arr.size()) {
	        	System.out.println(arr.get(index).toString());
	        }else {
	        	System.out.println("Vehicle not found");
	        }
	        
	        break;
      case 4:
    	  // printing all the arrayList element
    	  for(Vehicle data: arr) {
	        	System.out.println( data.toString());
	        }
    	  break;
      case 5:
    	  	// taking input from user
    	  	System.out.print("Name of vehicle: ");
	        name = scan.next();
	        System.out.print("direction [R/L]: ");
	        dir = scan.next().charAt(0);
	        System.out.print("Degrees [0-360]: ");
	        degrees = scan.nextInt();
	        
	        // finding vehicle
	        index = 0;
	        while(true) {	
	        	if(index == arr.size()) {
	        		break;
	        	}
	        	if(arr.get(index).getName().equals(name)) {
	        		break;
	        	}
	        	index++;
	        }
	    	
	        // change degrees only when vehicle is present
	        if(index != arr.size()) {
	        	if(dir == 'L')
	        		arr.get(index).turnLeft(degrees);
	        	else if(dir == 'R') {
	        		arr.get(index).turnRight(degrees);
	        	}
	        }
	        
	        break;
      case 6:
      	scan.close();
        System.exit(0);
      default:
        System.out.println("Wrong input!");
      }
    }
  }
}

