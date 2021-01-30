
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Loan implements Serializable {
  private static final long serialVersionUID = 2L;
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private java.util.Date loanDate;

  /** Default constructor */
  public Loan() {
    this(2.5, 1, 1000);
  }

  /** Construct a loan with specified annual interest rate,
      number of years and loan amount 
    */
  public Loan(double annualInterestRate, int numberOfYears,
      double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /** Return numberOfYears */
  public int getNumberOfYears() {
    return numberOfYears;
  }

  /** Set a new numberOfYears */
  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount */
  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  /** Find monthly payment */
  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
      (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    return monthlyPayment;    
  }

  /** Find total payment */
  public double getTotalPayment() {
    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    return totalPayment;    
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }
}

// Main Code:-

public class TestLoanClassStorage {
	  /** Main method */
	  public static void main(String[] args) {
		  String fileName = "Loan_Data.txt";
		  boolean operationOver = false;
		  // reading data from file
		  ArrayList<Loan> loanData = readDataFromFile(fileName);
		  
		  // Create a Scanner
		  Scanner input = new Scanner(System.in);
		  while(true) {
			  int key;
			  System.out.println("Press 1.............create new loan");
			  System.out.println("Press 2..............print all loan");
			  System.out.println("press 3...............save selected data");
			  System.out.println("Default...............save all data");
			  key = input.nextInt();
			  switch(key) {
			  case 1: 
				  Loan loan = readUserData(input);
				  loanData.add(loan);
				  break;
			  case 2:
				  printAllData(loanData);
				  break;
			  case 3:
				  operationOver = true;
				  System.out.println("enter starting index (0 based indexing)");
				  int start = input.nextInt();
				  System.out.println("enter ending index (this index value is not included)");
				  int end = input.nextInt();
				  if(writeDataToFile(fileName, loanData, start, end)) {
					  System.out.println("Data Saved Successfully :)");
				  }else {
					  System.out.println("operation Failed :(");
				  }
				  break;
			  default:
				  operationOver = true;
				  if(writeDataToFile(fileName, loanData)) {
					  System.out.println("Data Saved Successfully :)");
				  }else {
					  System.out.println("operation Failed :(");
				  }
				  break;
			  }
			  
			  if(operationOver) {
				  input.close();
				  break;
			  }	  
	    }
	   
	  }
	  
	  private static ArrayList<Loan> readDataFromFile(String filename) {
		  ArrayList<Loan> loanData = new ArrayList<>();
		  File file = new File(filename);
		  if(file.exists()) {
			  System.out.println("File is present");
			  FileInputStream fi = null;
			  ObjectInputStream obj = null;
			  try {
				   fi = new FileInputStream(file);
				   obj = new ObjectInputStream(fi);
			  
				  while(true) {
					  try {
						  Loan l1 = (Loan) obj.readObject();
						  loanData.add(l1);
					  }catch (EOFException e) {
						  System.out.println("file read");
						  break;
					  }
				  }
				  obj.close();
				  fi.close();
			  } catch (FileNotFoundException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  } catch (IOException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  } 
		  
		  }
		  return loanData;
	  }
	  private static Loan readUserData(Scanner input) {
		  // Enter yearly interest rate
		    
		  System.out.print("Enter yearly interest rate, for example, 8.25: ");
		  double annualInterestRate = input.nextDouble();

		    // Enter number of years
		  System.out.print("Enter number of years as an integer: ");
		  int numberOfYears = input.nextInt();

		    // Enter loan amount
		  System.out.print("Enter loan amount, for example, 120000.95: ");
		  double loanAmount =  input.nextDouble();

		    // Create Loan object
		  Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

		    // Display loan date, monthly payment, and total payment
		  System.out.printf("The loan was created on %s\n" +
		      "The monthly payment is %.2f\nThe total payment is %.2f\n",
		      loan.getLoanDate().toString(), loan.getMonthlyPayment(), 
		      loan.getTotalPayment());
		    
		    return loan;
	  }
	  private static boolean writeDataToFile(String filename, ArrayList<Loan> data) {
		  // flag to save status
		  boolean dataSaved = true;
		  
		  FileOutputStream file = null;
		  ObjectOutputStream obj = null;
		  try {
			  // creating objs to write our data
			  file = new FileOutputStream(new File(filename));
			  obj = new ObjectOutputStream(file);
			  
			  for(Loan l: data) {
				  obj.writeObject(l);
			  }
			  
			  // closing objs 
			  obj.close();
			  file.close();
		  } catch (FileNotFoundException e) {
			  dataSaved = false;
			  e.printStackTrace();
		  } catch (IOException e) {
			  dataSaved = false;
			  e.printStackTrace();
		  }
		  return dataSaved;
	  }
	  private static void printAllData(ArrayList<Loan> data) {
		  double totalLoanAmt = 0;
		  double totalMonthlyPayment = 0;
		  System.out.println("Loan Amount \t loan duration \t interest rate \t monthly payment");
		  for(Loan l: data) {
			  totalLoanAmt += l.getLoanAmount();
			  totalMonthlyPayment += l.getMonthlyPayment();
			  System.out.println(l.getLoanAmount() + "\t\t\t" + l.getNumberOfYears() + "\t\t" + l.getAnnualInterestRate() + "\t" + l.getMonthlyPayment());
		  }
		  System.out.printf("total Monthly Payment: %.2f and total loan Amount: %.2f\n\n", totalMonthlyPayment, totalLoanAmt);
	  }
	  private static boolean writeDataToFile(String filename, ArrayList<Loan> data, int start, int end) {
		  boolean dataSaved = true;
		  
		  FileOutputStream file = null;
		  ObjectOutputStream obj = null;
		  try {
			  // creating objs to write our data
			  file = new FileOutputStream(new File(filename));
			  obj = new ObjectOutputStream(file);
			  
			  for(int i = start; i < end; i++) {
				  obj.writeObject(data.get(i));
			  }
			  
			  // closing objs 
			  obj.close();
			  file.close();
		  } catch (FileNotFoundException e) {
			  dataSaved = false;
			  e.printStackTrace();
		  } catch (IOException e) {
			  dataSaved = false;
			  e.printStackTrace();
		  }
		  return dataSaved;
	  }

}
