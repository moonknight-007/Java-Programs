package vehicle;

import java.util.*;
import java.io.*;


abstract class Vehicle implements Comparable<Vehicle>, Cloneable{
	private String color;
	private String name;
	private String serialNumber;
	private int model;
	private int price;
	private int direction;
	private double speed;
	protected java.util.Scanner input;
	private Calendar buyingDate;
	
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
		this.buyingDate = Calendar.getInstance();
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
	public Calendar getBuyingDate() { return buyingDate; }
	
	// setter methods for all the variables.
	public void setColor(String color) {	this.color = color;	}
	public void setName(String name) { this.name = name; }
	public void setSerialNumber(String serialNum) { this.serialNumber = serialNum;	}
	public void setModel(int model) { this.model = model;	}
	public void setPrice(int price) { this.price = price;	}
	public void setDirection(int dir) { this.direction = dir;	}
	public void setSpeed(double speed) { this.speed = speed;	}
	public void setBuyingDate(Calendar buyingDate) { this.buyingDate = buyingDate; 	}
	
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
			veh.price= this.price;
			veh.model = this.model;
			veh.direction = this.direction;
			veh.speed = this.speed;
			veh.buyingDate = this.buyingDate;
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return veh;
	}
	
}

class Car extends Vehicle{
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
			car.power = this.power;
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return car;
	}
}

class Bicycle extends Vehicle{
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
			bicycle.gears = this.gears;
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return bicycle;
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
      System.out.println("6.........................Test clone method");
      System.out.println("7..............................Exit program");
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
    	  Car car1 = new Car("Tesla","Black",95000,2021,"ind-001",164,100);
    	  Car car2 = (Car)car1.clone();
    	  
    	  System.out.println("After cloning car:-");
    	  System.out.println(car1.toString());
    	  System.out.println(car2.toString());
    	  
    	  Calendar cal = Calendar.getInstance();
    	  cal.set(Calendar.YEAR, 2020);
    	  car2.setBuyingDate(cal);
    	  
    	  System.out.println("After changing buying date:-");
    	  System.out.println(car1.toString());
    	  System.out.println(car2.toString());	    	 
    	  break;
      case 7:
      	scan.close();
        System.exit(0);
      default:
        System.out.println("Wrong input!");
      }
    }
  }
}

