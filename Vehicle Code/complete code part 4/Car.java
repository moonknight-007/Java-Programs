import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Car extends Vehicle {
    private int power;
    private java.util.Date productionDate;


    public Car() {
    }

    public Car(String name, String color, int price, int model, String serialNr, int power) {
        super(name, color, price, model, serialNr);
        this.power = power;
        productionDate = new java.util.Date();
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }


    @Override
    public void setAllFields() {

    }

    @Override
    public String toString() {
        return super.toString() +
                " Power: " + power + " Production date: " + productionDate + "\n";
    }


    @Override
    public void turnLeft(int degrees) {
        if (degrees >= 0 && degrees <= 360) {
            degrees -= degrees;
        }
        if (degrees < 0) {
            degrees = 360 - degrees;
        } else if (degrees > 360) {
            degrees = degrees - 360;
        }
        setDirection(degrees);
    }

    @Override
    public void turnRight(int degrees) {
        if (degrees >= 0 && degrees <= 360) {
            degrees += degrees;
        }
        if (degrees < 0) {
            degrees = 360 - degrees;
        } else if (degrees > 360) {
            degrees = degrees - 360;
        }
        setDirection(degrees);
    }


    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    @Override
    public void accelerate(int speedFactor) {

        if (getSpeed() == 0)
            setSpeed(0.5 * speedFactor);
        else setSpeed(getSpeed() * speedFactor);
        if (getSpeed() > MAX_SPEED_CAR) {
            setSpeed(MAX_SPEED_CAR);
        }
        System.out.println("Speed of car is: " + getSpeed() + " km/h");
    }

    @Override
    public void breaks(int speedFactor) {
        setSpeed(getSpeed() / speedFactor);
        System.out.println("Speed of car is: " + getSpeed() + " km/h");
    }

    @Override
    public void writeData(PrintWriter out) throws IOException {
	super.writeData(out);
	out.printf(" %d,", power);
    }

    @Override
    public void readData(Scanner sc) throws IOException, InputMismatchException {
        try {
        	super.readData(sc);
        	setPower(Integer.parseInt(sc.next().trim()));
        }catch(InputMismatchException e) {
        	System.out.println("wrong input type");
        }
    }

}
