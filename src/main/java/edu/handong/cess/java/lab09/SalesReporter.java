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

	private int numberOfSalesmen;
	private double highestSales;
	private double averageSales;
	private SalesMen[] team; 
	
	/**
	 * This is main implement main method.
	 * It call run method.
	 * @param args
	 */
	public static void main(String [] args) {
		
		SalesReporter myReporter = new SalesReporter();
		myReporter.run();
		
	}
	/**
	 * This is run method.
	 * This method runs all method.
	 */
	public void run() {
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
		System.out.print("Enter number of sales associates :");
		Scanner myScanner = new Scanner(System.in);
		
		numberOfSalesmen = myScanner.nextInt(); 
	}
	/**
	 * This is getData method.
	 * Enter the sales men name and sales.
	 * and then this method save the data.
	 */
	public void getData() {
		
		team = new SalesMen[numberOfSalesmen];
		
		Scanner myScanner = new Scanner(System.in);
		
		for(int i=0 ; i<numberOfSalesmen ; i++) {
			
			//team = new SalesMen[i];
			
			team[i]= new SalesMen();
			
		
			System.out.println("Enter data for associate number "+ (i+1));
			
			System.out.print("Enter name of sales associate :");
			String name = myScanner.nextLine();
			
			System.out.print("Enter associate's sales: $");
			double sales = myScanner.nextDouble();
			myScanner.nextLine();
			
			team[i].setName(name);			
			team[i].setSales(sales);
			
		}
	}
	/**
	 * This is computeSates method.
	 * It computes average sales.
	 */
	public void computeSates() {
		
		double sum = 0;
		
		for(int i=0 ; i<team.length ; i++) {
			
			double sales = team[i].getSales();
			sum = sum + sales;
			
		}
		
		averageSales = sum/numberOfSalesmen;
	}
	/**
	 * This is highestSales method
	 * It finds highest sales and saves the data.
	 */
	public void highestSales() {
		
		
		for(int i=0 ; i<team.length-1 ; i++) {
			
			if(team[i].getSales() < team[i+1].getSales()) {
				highestSales = team[i+1].getSales();
			}
		}
		
		
	}
	/**
	 * This method is distanceFromAverage
	 * It saves each salesmen's data that is difference sales from average sales.
	 */
	public void distanceFromAverage() {
		double distance;
		for(int i=0 ; i<team.length ; i++) {
			distance=Math.abs((team[i]).getSales()-averageSales);
			team[i].setDistance(distance);
		}
	}
	/**
	 * This is Compare method.
	 * It saves each salesmen's data.
	 * if first salesmen's sales are higher than average sales, the data is "above"
	 * else the data is "below"
	 */
	public void Compare() {
		String compare;
		for(int i=0 ; i<numberOfSalesmen ; i++) {
			if(averageSales>team[i].getSales()) team[i].setCompare("below");
			else team[i].setCompare("above");
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
		System.out.print("Average sales per associate is $");
		System.out.printf("%.1f\n",averageSales);
		System.out.println("The hightest slaes figure is $" + highestSales);
		
		
		System.out.println("The following had the hightest slaes:");
		for(int i=0 ; i<team.length; i++) {
			if(team[i].getSales()==highestSales) {
				System.out.println("Name :" + team[i].getName());
				System.out.println("Sales : $" + team[i].getSales());
				System.out.println(team[i].getDistance() + "above the average");
				System.out.println("\n");
			}
		}
		
		System.out.println("The rest performed as follows");
		for(int i=0 ; i<team.length; i++) {
			if(team[i].getSales()!=highestSales) {
				System.out.println("Name :" + team[i].getName());
				System.out.println("Sales : $" + team[i].getSales());
				System.out.println(team[i].getDistance() + team[i].getCompare() + " the average");
				System.out.println("\n");
				
			}
		}
		
	}
	
	
	
}
