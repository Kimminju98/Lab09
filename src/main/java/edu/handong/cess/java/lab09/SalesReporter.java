package edu.handong.cess.java.lab09;
import java.util.Scanner;

/**
 * This is SalesReporter class
 * It has main,run,SalesReporter,getData(),computeSates(),highestSales(),distanceFromAverage(),Compare(),displayResults() methods.
 * <p>
 * This object get SalesMen information and print out all salesMen information and highest sales men
 * 
 * @author MinJu
 *
 */
public class SalesReporter {

	private int numberOfSalesmen; // It is total number of salesmen.
	private double highestSales; // It is highest salesmen's sales.
	private double averageSales; // It is average of salesmen's sales.
	private SalesMen[] team;  // This array need to get same type information about salesmen and it's type is SalesMen class.
	
	/**
	 * This is main implement main method.
	 * It call run method.
	 * @param args
	 */
	public static void main(String [] args) {
		
		SalesReporter myReporter = new SalesReporter(); // Instantiate SalesReporter by using myReporter name
		myReporter.run(); // call run method.
		
	}
	/**
	 * This is run method.
	 * This method runs all method.
	 */
	public void run() {  // in the run method, the other methods need not instantiate. just call!
		getData();
		computeSates();
		highestSales();
		distanceFromAverage();
		Compare();
		displayResults();
	}
	/**
	 * This is SalesReporter method.
	 * It is constructor.
	 * Enter the number of salesmen.
	 */
	public SalesReporter() {
		System.out.print("Enter number of sales associates :"); // print out the string.
		Scanner myScanner = new Scanner(System.in); // instantiate Scanner class.
		
		numberOfSalesmen = myScanner.nextInt(); // put the user's input to numberOfSalesmen.
	}
	/**
	 * This is getData method.
	 * Enter the sales men name and sales.
	 * and then this method save the data.
	 */
	public void getData() {
		
		team = new SalesMen[numberOfSalesmen]; // instantiate team array. Instantiated number is same as numberOfSalesmen.
		
		Scanner myScanner = new Scanner(System.in); // instantiate Scanner class.
		
		for(int i=0 ; i<numberOfSalesmen ; i++) { // numberOfSalesmen times repeat.
			
			//team = new SalesMen[i];
			
			team[i]= new SalesMen(); // instantiate each of sales men by using team array
			
		
			System.out.println("Enter data for associate number "+ (i+1)); // show the number of salesmen.
			 
			System.out.print("Enter name of sales associate :"); // print out string.
			String name = myScanner.nextLine(); // put salesmen's name to name.
			
			System.out.print("Enter associate's sales: $"); // print out string.
			double sales = myScanner.nextDouble(); // put salesmen's sales to sales. 
			myScanner.nextLine(); // It needs to avoid nextDouble problem.
			
			team[i].setName(name); // call setName method and give name			
			team[i].setSales(sales); // call setSales method and give sales.
			
		}
	}
	/**
	 * This is computeSates method.
	 * It computes average sales.
	 */
	public void computeSates() {
		
		double sum = 0; //It needs to sum all salesmen's sales.
		
		for(int i=0 ; i<team.length ; i++) { // numberOfSalesmen times repeat.
			
			double sales = team[i].getSales(); // call getSales method to save sales information in sales.
			sum = sum + sales; // sum sales.
			
		}
		
		averageSales = sum/numberOfSalesmen; // compute average sales.
	}
	/**
	 * This is highestSales method
	 * It finds highest sales and saves the data.
	 */
	public void highestSales() {
		
		highestSales=team[0].getSales(); // highest sales is first sales's men sales at first. 
		for(int i=0 ; i<team.length-1 ; i++) { // numberOfSalesmen times repeat.
			
			if(team[i].getSales() < team[i+1].getSales()) { // compare two salesmen's sales and if next salesmen's sales is higher than smaller number's salesmen's sales.
				highestSales = team[i+1].getSales(); // Change the highestSales to next salesmen's sales.
			}
		}
		
		
	}
	/**
	 * This method is distanceFromAverage
	 * It saves each salesmen's data that is difference sales from average sales.
	 */
	public void distanceFromAverage() {
		double distance; // It is used to compute difference sales from average sales.
		for(int i=0 ; i<team.length ; i++) { // Repeat number of salesmen times
			distance=Math.abs((team[i]).getSales()-averageSales); // Put each of salesmen's sales - average sales to distance.
			team[i].setDistance(distance); // call setDistance method to save distance about each of salesmen.
		}
	}
	/**
	 * This is Compare method.
	 * It saves each salesmen's data.
	 * if first salesmen's sales are higher than average sales, the data is "above"
	 * else the data is "below"
	 */
	public void Compare() {
		String compare; // It is used to compare each of sales'men sales to average sales and save the string
		for(int i=0 ; i<numberOfSalesmen ; i++) { // Repeat number of salesmen times.
	    if(averageSales>team[i].getSales()) team[i].setCompare("below"); // if average sales is higher than each salesmen's sales, save below t
			else team[i].setCompare("above"); // else save above
		}
	}
	/**
	 * This is displayResults method.
	 * It prints out all sales men information
	 * first, it prints out average sales and highest sales.
	 * second, it prints out highest sales men's name and sales, distance from average sales.
	 * finally it prints out other sales men's informations that are same as highest sales men.
	 */
	public void displayResults() {
		//String averageSales=String.format("%.1f", averageSales);
		System.out.print("Average sales per associate is $"); // print out string
		System.out.printf("%.1f\n",averageSales); // print out average sales.
		System.out.println("The hightest slaes figure is $" + highestSales); // print out highest sales.
		
		
		System.out.println("The following had the hightest slaes:"); // print out string
		for(int i=0 ; i<team.length; i++) { // Repeat number of salesmen times.
			if(team[i].getSales()==highestSales) { // if some salesmen's sales is same as highestSales
				System.out.println("Name :" + team[i].getName()); // print out that salesmen's name
				System.out.println("Sales : $" + team[i].getSales()); // print out that salesmen's sales
				System.out.println(team[i].getDistance() + "above the average"); //// print out that salesmen's distance
				System.out.println("\n");
			}
		}
		
		System.out.println("The rest performed as follows"); // print out string.
		for(int i=0 ; i<team.length; i++) { // Repeat number of salesmen times.
			if(team[i].getSales()!=highestSales) { // That is print out all sales's men information except highest salesmen.
				System.out.println("Name :" + team[i].getName()); // print out that salesmen's name
				System.out.println("Sales : $" + team[i].getSales()); // print out that salesmen's sales.
				System.out.println(team[i].getDistance() + team[i].getCompare() + " the average"); // print out that salesmen's distance and below or above
				System.out.println("\n");
				
			}
		}
		
	}
	
	
	
}
