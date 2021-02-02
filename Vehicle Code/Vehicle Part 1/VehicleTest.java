import java.io.IOException;
import java.util.ArrayList;
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
	         System.out.println("6..............................Exit program");
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
	        	 scan.close();
	        	 System.exit(0);
	        	 break;
	         default:
	        	 System.out.println("Wrong input");
	        	 
	         }
	    }
	    
	}
	
}
