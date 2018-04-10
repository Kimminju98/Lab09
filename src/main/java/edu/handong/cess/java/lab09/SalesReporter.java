package edu.handong.cess.java.lab09;
import java.util.Scanner;


public class SalesReporter {

	private int numberOfSalesmen;
	private double highestSales;
	private double averageSales;
	private SalesMen[] team; 
	
	
	public static void main(String [] args) {
		
		SalesReporter myReporter = new SalesReporter();
		myReporter.getData();
		myReporter.computeSates();
		myReporter.hightestSales();
		myReporter.distanceFromAverage();
		myReporter.Compare();
		myReporter.displayResults();
		
	}
	
	public SalesReporter() {
		System.out.print("Enter number of sales associates :");
		Scanner myScanner = new Scanner(System.in);
		
		numberOfSalesmen = myScanner.nextInt(); 
	}
	
	public void getData() {
		
		team = new SalesMen[numberOfSalesmen];
		
		Scanner myScanner = new Scanner(System.in);
		
		for(int i=0 ; i<numberOfSalesmen ; i++) {
			
			//team = new SalesMen[i];
			
			team[i]= new SalesMen();
			
		
			System.out.println("Enter data for associate number "+ (i+1));
			
			System.out.print("Enter name of slaes associate :");
			String name = myScanner.nextLine();
			
			System.out.print("Enter associate's sales: $");
			double sales = myScanner.nextDouble();
			myScanner.nextLine();
			
			team[i].setName(name);			
			team[i].setSales(sales);
			
		}
	}
	public void computeSates() {
		
		double sum = 0;
		
		for(int i=0 ; i<team.length ; i++) {
			
			double sales = team[i].getSales();
			sum = sum + sales;
			
		}
		
		averageSales = sum/numberOfSalesmen;
	}
	
	public void hightestSales() {
		
		
		for(int i=0 ; i<team.length-1 ; i++) {
			
			if(team[i].getSales() < team[i+1].getSales()) {
				highestSales = team[i+1].getSales();
			}
		}
		
		
	}
	
	public void distanceFromAverage() {
		double distance;
		for(int i=0 ; i<team.length ; i++) {
			distance=Math.abs((team[i]).getSales()-averageSales);
			team[i].setDistance(distance);
		}
	}
	
	public void Compare() {
		String compare;
		for(int i=0 ; i<numberOfSalesmen ; i++) {
			if(averageSales>team[i].getSales()) team[i].setCompare("below");
			else team[i].setCompare("above");
		}
	}
	
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
