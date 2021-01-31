import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;



public class VehicleTest {
    public static void main(String[] args) {
        VehicleTest vtest = new VehicleTest();
        try {
            vtest.menuLoop();
        } catch (IOException e) {
            System.out.println("IO Exception!");
            System.exit(1);
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
            System.exit(1);

        }
    }

    private void menuLoop() throws IOException, CloneNotSupportedException {
        String fileName = "VehicleData1.txt";
		File dataFile = new File(fileName);
		
	Scanner scan = new Scanner(System.in);
	    ArrayList<Vehicle> vehicleList= readDataFromFile(dataFile);//new ArrayList<Vehicle>();
	    Vehicle vehicle;

        while (true) {
            System.out.println("\n.Welcome to vehicle listing, choose action.");
            System.out.println("1...................................New car");
            System.out.println("2...............................New bicycle");
            System.out.println("3......................Find vehicle by name");
            System.out.println("4..............Show data about all vehicles");
            System.out.println("5.......Change direction of a given vehicle");
            System.out.println("6.........................Test clone method");
            System.out.println("7..................Test driveable interface");
            System.out.println("8..............................Exit program");
            System.out.print("................................Your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    //creates cars
                    System.out.println("Enter car name: ");
                    String carName = scan.next();
                    System.out.println("Enter color ");
                    String carColor = scan.next();
                    System.out.println("Enter price: ");
                    int carPrice = scan.nextInt();
                    System.out.println("Enter year of manufacture: ");
                    int carModel = scan.nextInt();
                    System.out.println("Enter registration: ");
                    String carSerialNr = scan.next();
                    System.out.println("Enter horsepower: ");
                    int carPower = scan.nextInt();
                    Vehicle car = new Car(carName, carColor, carPrice, carModel, carSerialNr, carPower);
                    vehicleList.add(car);
                    break;

                case 2:
                    //creates bicycles
                    System.out.println("Enter bicycle name: ");
                    String bikeName = scan.next();
                    System.out.println("Enter color ");
                    String bikeColor = scan.next();
                    System.out.println("Enter price: ");
                    int bikePrice = scan.nextInt();
                    System.out.println("Enter year of manufacture: ");
                    int bikeModel = scan.nextInt();
                    System.out.println("Enter registration: ");
                    String bikeSerialNr = scan.next();
                    System.out.println("Enter number of gears: ");
                    int bikeGears = scan.nextInt();
                    Vehicle bike = new Bicycle(bikeName, bikeColor, bikePrice, bikeModel, bikeSerialNr, bikeGears);
                    vehicleList.add(bike);
                    break;
                case 3:
                    // vis info om gitt kjøretøy
                    System.out.println("Name of vehicle: ");
                    String vehicleName = scan.next();
                    int nameList = vehicleList.size();

                    for (int i = 0; i < nameList; i++) {
                        if (vehicleName.equals(vehicleList.get(i).getName())) {
                            System.out.println(vehicleList.get(i));
                        }
                    }
                    break;
                case 4:
                    // vis info om alle kjøretøy
                    System.out.println(vehicleList);
                    break;
                case 5:
                    // Finn kjøretøy med gitt navn, sett ny retning
                    System.out.println("Name of vehicle: ");
                    String vehicleNameDir = scan.next();

                    for (Vehicle obj : vehicleList) {
                        if (obj.getName().equals(vehicleNameDir)) {
                            if (obj instanceof Car) {
                                System.out.println("Direction you wish to choose, [R/L]");
                                String direction = scan.next();
                                if (direction.equals("L")) {
                                    System.out.println("Enter number of degrees: ");
                                    ((Car) obj).turnLeft(scan.nextInt());
                                } else if (direction.equals("R")) {
                                    System.out.println("Enter number of degrees: ");
                                    ((Car) obj).turnRight(scan.nextInt());
                                }
                            } else if (obj instanceof Bicycle) {
                                System.out.println("Direction you wish to choose, [R/L]");
                                String bikeDirection = scan.next();
                                if (bikeDirection.equals("R")) {
                                    System.out.println("Enter number of degrees: ");
                                    ((Bicycle) obj).turnRight(scan.nextInt());
                                } else if (bikeDirection.equals("L")) {
                                    System.out.println("Enter number of degrees: ");
                                    ((Bicycle) obj).turnLeft(scan.nextInt());
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    //test clone interface
                    Vehicle originalCar = new Car("Volvo", "Red", 12345, 2017, "123QWE", 295);
                    Vehicle cloneCar = (Vehicle) originalCar.clone();
                    cloneCar.setModel(2018);
                    System.out.println(originalCar);
                    System.out.println(cloneCar);
                    compare(originalCar, cloneCar);
                    break;
                case 7:
                    //test driveable interface
                    Car testCar = new Car("Lada", "Green", 31425, 1980, "313131", 90);
                    System.out.println("Car: ");
                    testCar.accelerate(15);
                    testCar.accelerate(1000);
                    testCar.breaks(50);
                    testCar.stop();
                    System.out.println("Speed of car is: " + testCar.getSpeed() + " km/h");

                    Bicycle testBicycle = new Bicycle("Merida", "Black, red and gold", 30000, 2020, "131313", 18);
                    System.out.println("\nBicycle: ");
                    testBicycle.accelerate(15);
                    testBicycle.accelerate(1000);
                    testBicycle.breaks(20);
                    testBicycle.stop();
                    System.out.println("Speed of bicycle is: " + testBicycle.getSpeed() + " km/h");
                    break;
                case 8:
                default:
                	Collections.sort(vehicleList);
                	System.out.println("vehicle list sorted according to price");
                	/*for(Vehicle vh: vehicleList) {
                		System.out.println(vh.toString());
                	}*/
		    try {
	    		  String className;
	    		  FileWriter fw = new FileWriter(fileName);
	    		  PrintWriter pw = new PrintWriter(fw);
	    		  for(Vehicle vh: vehicleList) {
	    			  className = vh.getClass().getName().toString();
	    			  //pw.write(" " + className.substring(className.lastIndexOf(".") + 1) + ",");
	    			  pw.write(" " + className + ",");
	    			  vh.writeData(pw);
	    		  }
	    		  
	    		  pw.close();
	    		  System.out.println("data stored in file");
	    	  }catch(IOException e) {
	    		  System.out.println("File IO error when saving data");
	    	  }
                    System.out.println("Goodbye.");
                    scan.close();
                    System.exit(0);
            }
        }
    }

    private ArrayList<Vehicle> readDataFromFile(File file){
		String vehClass = "";
		Scanner inputScan = null;
		ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
		if(file.exists()) {
			try {
				inputScan = new Scanner(file);
				inputScan.useDelimiter(",");
				
				System.out.println("Reading Data from file");
				while(inputScan.hasNext()) {
					vehClass = inputScan.next().trim();
					if(vehClass.isBlank())
						break;
					
					Class veh1 = Class.forName(vehClass);
					Vehicle veh = (Vehicle) veh1.newInstance();
					veh.readData(inputScan);
					arr.add(veh);
				}
				inputScan.close();
			}catch(FileNotFoundException e) {
				System.out.println("File not found");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				System.out.println(vehClass + ": Class not found exception");
			} catch(IOException e) {
				System.out.println("IOException");
			}finally {
				if(inputScan!=null) {
					inputScan.close();
				}
			}
		}
		System.out.println("arrayList size:" + arr.size());
		return arr;
	}
    
    public static void compare(Object obj1, Object obj2) {
        if (obj1 == obj2)
            System.out.println("Shallow copy");
        else System.out.println("Deep copy");
    }

}