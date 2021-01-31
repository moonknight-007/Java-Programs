import java.io.*;
import java.util.*;
import java.util.Scanner;

public abstract class Vehicle implements Serializable, Fileable, Driveable, Cloneable, Comparable<Vehicle> {
    private String color;
    private String name;
    private String serialNr;
    private int model;
    private int price;
    private int direction;
    private double speed;
    private GregorianCalendar buyingDate;
    protected java.util.Scanner input;

    public Vehicle() {
    }

    public Vehicle(String name, String color, int price, int model, String serialNr) {
        this.color = color;
        this.price = price;
        this.name = name;
        this.serialNr = serialNr;
        this.model = model;
        this.buyingDate = new GregorianCalendar();
    }

    public void setAllFields() {
        Scanner input;
    }

    public abstract void turnLeft(int degrees);

    public abstract void turnRight(int degrees);


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNr() {
        return serialNr;
    }

    public void setSerialNr(String serialNr) {
        this.serialNr = serialNr;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public GregorianCalendar getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(GregorianCalendar buyingDate) {
        this.buyingDate = buyingDate;
    }

    //compare interface
    public int compareTo(Vehicle other) {
        if (this.getPrice() > other.getPrice()) {
            //System.out.println("Vehicles shown by descending price: ");
            //System.out.println(this.toString());
            //System.out.println(other.toString());
            return 1;
        } else if (this.getPrice() < other.getPrice()) {
            //System.out.println("Vehicles shown by ascending price: ");
            //System.out.println(other.toString());
            //System.out.println(this.toString());
            return -1;
        }
        return 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Vehicle clone = null;
        try {
            clone = (Vehicle) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return
                "Name: " + name + " Color: " + color + " Price: " + price + " Model: " + model + " Registration: " + serialNr
                        + " Direction: " + direction + " Speed: " + speed + " Buying date: " + buyingDate.get(Calendar.YEAR) + "-" + (buyingDate.get(Calendar.MONTH) + 1)+"-"+buyingDate.get(Calendar.DATE);
    }

    @Override
    public void stop() {
        setSpeed(0.0);
        System.out.println("Vehicle stops");
    }


    public void writeData(PrintWriter out) throws IOException {
        out.printf(" %s, %s, %d, %d, %s, %d, %f, %d, %d, %d,", 
					name, 
					color, 
					price, 
					model, 
					serialNr, 
					direction, 
					speed, 
					buyingDate.get(Calendar.DATE),
					buyingDate.get(Calendar.MONTH) + 1,
					buyingDate.get(Calendar.YEAR));
    }

    public void readData(Scanner sc) throws IOException {
		try {
			this.name = sc.next().trim();
			this.color = sc.next().trim();
			this.price = Integer.parseInt(sc.next().trim());
			this.model = Integer.parseInt(sc.next().trim());
			this.serialNr = sc.next().trim();
			this.direction = Integer.parseInt(sc.next().trim());
			this.speed = Double.parseDouble(sc.next().trim());
			int date = Integer.parseInt(sc.next().trim());
			int month = Integer.parseInt(sc.next().trim()) -1;
			int yr = Integer.parseInt(sc.next().trim());
			this.buyingDate = new GregorianCalendar(yr, month, date);
		}catch(InputMismatchException e) {
			System.out.println("wrong input type1");
		}catch(NumberFormatException e) {
			System.out.println("readin wrong number type");
		}
    }
}
