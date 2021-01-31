import java.io.File;
import java.io.*;
import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bicycle extends Vehicle {
    private int gears;
    private java.util.Date productionDate;

    public Bicycle() {
    }

    public Bicycle(String name, String color, int price, int model, String serialNr, int gears) {
        super(name, color, price, model, serialNr);
        this.gears = gears;
        productionDate = new java.util.Date();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }


    @Override
    public void setAllFields() {

    }

    @Override
    public void turnLeft(int degrees) {
        degrees -= degrees;
        setDirection(degrees);
    }

    @Override
    public void turnRight(int degrees) {
        degrees += degrees;
        setDirection(degrees);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Gears: " + gears + " Production date: " + productionDate + "\n";
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void accelerate(int speedFactor) {
        if (getSpeed() == 0)
            setSpeed(0.3 * speedFactor);
        else setSpeed(0.5 * getSpeed() * speedFactor);
        if (getSpeed() > MAX_SPEED_BIKE) {
            setSpeed(MAX_SPEED_BIKE);
        }
        System.out.println("Speed of bicycle is : " + getSpeed() + " km/h");
    }

    @Override
    public void breaks(int speedFactor) {
        setSpeed(getSpeed() / (speedFactor * 0.5));
        System.out.println("Speed of bicycle is : " + getSpeed() + " km/h");
    }

    @Override
    public void writeData(PrintWriter out) throws IOException {
        super.writeData(out);
	out.printf(" %d, ", gears);
    }

    @Override
    public void readData(Scanner in) throws IOException {
        try {
    	super.readData(in);
        this.gears = Integer.parseInt(in.next().trim());
        }catch(InputMismatchException e) {
  		  System.out.println("Wrong Input Type found");
  	  }
    }
}
