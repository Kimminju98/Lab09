package edu.handong.cess.java.lab09;
import java.util.ArrayList;
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

	private double highestSales; // It is highest salesmen's sales.
	private double averageSales; // It is average of salesmen's sales.
	private ArrayList<SalesMen> team; // change the team array to team array list.
	
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
	 * This is getData method.
	 * Enter the sales men name and sales.
	 * and then this method save the data.
	 */
	public void getData() {
		
		team = new ArrayList<SalesMen>(); // instantiate team arraylist. the object is SalesMen.
		
		Scanner myScanner = new Scanner(System.in); // instantiate Scanner class.
		int i=0;
		
		while(true) { 
			System.out.println("Enter data for associate number "+ (i+1)); // show the number of salesmen.
			 
			System.out.print("Enter name of sales associate :"); // print out string.
			String name = myScanner.nextLine(); // put salesmen's name to name.
			
			System.out.print("Enter associate's sales: $"); // print out string.
			double sales = myScanner.nextDouble(); // put salesmen's sales to sales. 
			myScanner.nextLine(); // It needs to avoid nextDouble problem.
			
			team.add(new SalesMen(name,sales));
			i++;
			
			System.out.print("Do you want to enter more information?(y or n) "); // if user want to stop, enter the n
			String is = myScanner.nextLine();
			if(is.equals("n")) break; // while statement exit.
			
		}
	}
	/**
	 * This is computeSates method.
	 * It computes average sales.
	 */
	public void computeSates() {
		
		double sum = 0; //It needs to sum all salesmen's sales.
		int i=0;
		for(SalesMen e : team) { // repeat until team is exit
			double sales = team.get(i).getSales(); // input each of team's Sales information to sales.
			sum = sum + sales; // sum sales.
			i++;
		}
		
		averageSales = sum/team.size(); 
	}
	/**
	 * This is highestSales method
	 * It finds highest sales and saves the data.
	 */
	public void highestSales() {
		
		highestSales=team.get(0).getSales(); // highest sales is first sales's men sales at first. 
		for(int i=0 ; i<team.size()-1 ; i++) {  // repeat size of team -1 times.
			
			if(team.get(i).getSales() < team.get(i+1).getSales()) { // compare two salesmen's sales and if next salesmen's sales is higher than smaller number's salesmen's sales.
				highestSales = team.get(i+1).getSales(); // Change the highestSales to next salesmen's sales.
			}
		}
		
		
	}
	/**
	 * This method is distanceFromAverage
	 * It saves each salesmen's data that is difference sales from average sales.
	 */
	public void distanceFromAverage() {
		double distance; // It is used to compute difference sales from average sales.
		for(int i=0 ; i<team.size() ; i++) { 
			distance=Math.abs((team.get(i)).getSales()-averageSales); 
			team.get(i).setDistance(distance); 
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
		for(int i=0 ; i<team.size() ; i++) {
	    if(averageSales>team.get(i).getSales()) team.get(i).setCompare("below"); // if average sales is higher than each salesmen's sales, save below t
			else team.get(i).setCompare("above"); // else save above
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
		for(int i=0 ; i<team.size(); i++) { // Repeat number of teams times.
			if(team.get(i).getSales()==highestSales) { // if some salesmen's sales is same as highestSales
				System.out.println("Name :" + team.get(i).getName()); // print out that salesmen's name
				System.out.println("Sales : $" + team.get(i).getSales()); // print out that salesmen's sales
				System.out.println(team.get(i).getDistance() + "above the average"); //// print out that salesmen's distance
				System.out.println("\n");
			}
		}
		
		System.out.println("The rest performed as follows"); // print out string.
		for(int i=0 ; i<team.size(); i++) { // Repeat number of teams times.
			if(team.get(i).getSales()!=highestSales) { // That is print out all sales's men information except highest salesmen.
				System.out.println("Name :" + team.get(i).getName()); // print out that salesmen's name
				System.out.println("Sales : $" + team.get(i).getSales()); // print out that salesmen's sales.
				System.out.println(team.get(i).getDistance() + team.get(i).getCompare() + " the average"); // print out that salesmen's distance and below or above
				System.out.println("\n");
				
			}
		}
		
	}
	
	
	
}
