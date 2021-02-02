import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class VehicleTest {
	public static void main(String[] args) {
		VehicleTest vtest = new VehicleTest();
		try {
			vtest.menuLoop();
		}catch(IOException e) {
			System.out.println("IO Exception!");
			System.exit(1);
		}catch(CloneNotSupportedException e) {
			System.out.println("CloneNotSupportedException");
			System.exit(1);
		}
	}
	
	private void menuLoop() throws IOException, CloneNotSupportedException{
		Scanner scan = new Scanner(System.in);
		ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
		
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
	         System.out.println("7..................Test driveable interface");
		     System.out.println("8..............................Exit program");
	         System.out.println(".............................Your choice?");
	         int choice = scan.nextInt();
	         
	         String name;
	         int index;
	         char dir;
	         int degrees;
	         
	         switch(choice) {
	         case 1:
	        	 Car car = new Car();
	        	 car.setAllFields();
	        	 arr.add(car);
	        	 break;
	         case 2:
	        	 Bicycle bicycle = new Bicycle();
	        	 bicycle.setAllFields();
	        	 arr.add(bicycle);
	        	 break;
	         case 3:
	        	 System.out.print("Name of vehicle you want to search: ");
	        	 name = scan.next();
	        	 index = 0;
	        	 while(true) {
	        		 if(index == arr.size())
	        			 break;
	        		 if(arr.get(index).getName().equals(name))
	        			 break;
	        		 index++;
	        	 }
	        	 if(index != arr.size())
	        		 System.out.println(arr.get(index).toString());
	        	 else
	        		 System.out.println("Vehicle not found :(");
	        	 break;
	         case 4:
	        	 for(Vehicle veh: arr) {
	        		 System.out.println(veh.toString());
	        	 }
	        	 break;
	         case 5:
	        	 System.out.print("Name of vehicle: ");
	        	 name = scan.next();
	        	 System.out.print("direction [R/L]: ");
	        	 dir = scan.next().charAt(0);
	        	 System.out.print("Degrees [0-360]: ");
	        	 degrees = scan.nextInt();
	        	 
	        	 index = 0;
	        	 while(true) {
	        		 if(index == arr.size())
	        			 break;
	        		 if(arr.get(index).getName().equals(name))
	        			 break;
	        		 index++;
	        	 }
	        	 if(index != arr.size()) {
	        		 if(dir == 'L' || dir == 'l')
	        			 arr.get(index).turnLeft(degrees);
	        		 else if(dir == 'R' || dir == 'r')
	        			 arr.get(index).turnRight(degrees);
	        		 else
	        			 System.out.println("invalid direction");
	        	 }
	        	 break;
	         case 6:
	        	 Car car1 = new Car("Tesla", "Black", 95000, 2021, "ind-001", 164, 100);
	        	 Car car2 = (Car) car1.clone();
	        	 System.out.println("After cloning car:-");
	        	 System.out.println(car1.toString());
	        	 System.out.println(car2.toString());
	        	 
	        	 Calendar cal = Calendar.getInstance();
	        	 cal.set(Calendar.YEAR, 2015);
	        	 cal.set(Calendar.MONTH, 5);
	        	 cal.set(Calendar.DATE, 21);
	        	 car2.setBuyingDate(cal);
	        	 car2.setName("car2");
	        	 
	        	 System.out.println("\nafter cloning car and changing date and name:-");
	        	 System.out.println(car1.toString());
	        	 System.out.println(car2.toString());
	        	 break;
	         case 7:
	        	 Car veh1 = new Car("Tesla", "Dark Blue", 97000, 2021, "nor-002", 125, 123);
		    	 Bicycle veh2 = new Bicycle("Arrow", "Dark Red", 4500, 2020, "spider-01", 145, 0);
		    	  
				  System.out.println("Vehicle: Car");
				  veh1.accelerate(10);
		    	  veh1.accelerate(20);
		    	  veh1.breaks(5);
		    	  veh1.stop();
				  
				  System.out.println("\nVehicle: Bike");
				  veh2.accelerate(10);
		    	  veh2.accelerate(200);
		    	  veh2.breaks(5);
		    	  veh2.stop();
				  break;
	         case 8:
	        	 scan.close();
	        	 System.exit(0);
	        	 break;
	         default:
	        	 System.out.println("Wrong input");
	        	 
	         }
	    }
	    
	}
	
}
