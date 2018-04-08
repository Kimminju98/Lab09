package handong.edu.cess.java.sale;
import java.util.Scanner;

//above 이런거 해주기

public class SalesReporter {

	private int numberOfSalesmen;
	private double highestSales;
	private double averageSales;
	private int numberOfAssociates;
	private SalesMen[] team; // array 하나에 여러 information 담을 수 있다.  클래스를 그것으로
	// 여기에 team을 instantiate 할 수 없는 이유는 : team의 size를 모르기 때문이다.
	
	public static void main(String [] args) {
		
		SalesReporter myReporter = new SalesReporter();
		myReporter.getData();
		myReporter.computeSates();
		
	}
	
	public SalesReporter() {
		System.out.print("Enter number of sales associates :");
		Scanner myScanner = new Scanner(System.in);
		
		numberOfSalesmen = myScanner.nextInt(); 
	}
	
	public void getData() {
		
		team = new SalesMen [numberOfSalesmen];
		
		for(int i=0 ; i<numberOfSalesmen ; i++) {
			
			//team[i]= new SalesMen();
			
			Scanner myScanner = new Scanner(System.in);
			System.out.println("Enter data for associate number "+ (i+1));
			
			System.out.print("Enter name of slaes associate :");
			String name = myScanner.nextLine();
			
			System.out.print("Enter associate's sales");
			double sales = myScanner.nextDouble();
			
			//SalesMen mySalesMen = new SalesMen(); //이런식으로 해줘야되는데, 이때 어레이 사용
		    //mySalesMen.setName(name);
			//mySalesMen.setSales(sales);
			
			team[i].setName(name); //array도 타입이고, instantiate 해줘야된다. 아니면 메모리 할당이 안된다.
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
		System.out.println("Average sales per associate is " + averageSales);
		System.out.println("The hightest slaes figure is  " + highestSales);
		
		
		System.out.println("The following had the hightest slaes:");
		for(int i=0 ; i<team.length; i++) {
			if(team[i].getSales()==highestSales) {
				System.out.println("Name :" + team[i].getName());
				System.out.println("Sales :" + team[i].getSales());
				System.out.println(team[i].getDistance() + "above the average");
				System.out.println("\n");
			}
		}
		
		System.out.println("Other sales guys");
		for(int i=0 ; i<team.length; i++) {
			if(team[i].getSales()!=highestSales) {
				System.out.println("Name :" + team[i].getName());
				System.out.println("Sales :" + team[i].getSales());
				System.out.println(team[i].getDistance() + team[i].getCompare() + " the average");
				System.out.println("\n");
				
			}
		}
		
	}
	
	
	// rename, 자동완성기능, 두줄 띄우고 싶을때
	
}
