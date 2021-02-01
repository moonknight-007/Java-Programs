import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
	    	  
	    	  car2.setName("Car2");
	    	  car2.setColor("white");
	    	  car2.setBuyingDate(new GregorianCalendar(2015, 06, 1));
	    	  car2.setSpeed(15);
	    	  
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

