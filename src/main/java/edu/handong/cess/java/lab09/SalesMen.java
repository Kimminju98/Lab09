package edu.handong.cess.java.lab09;
/**
 * This is SalesMen class
 * It has getter and setter method about name,sales,distance,compare
 * 
 * @author MinJu
 *
 */
public class SalesMen { // This class needed to hide information.

	private String name; // This is name information
	private double sales; // This is sales information
	private double distance; // This is distance information
	private String compare; // This is compare information
	/**
	 * This is getCompare method.
	 * @return compare string type
	 */

	public SalesMen(String name, double sales) {
		this.name = name;
		this.sales = sales;
	}
	public String getCompare() {
		return compare; 
	}
	/**
	 * This is setCompare method
	 * @param compare string type
	 */
	public void setCompare(String compare) {
		this.compare = compare; // save parameter compare to this class's compare members.
	}
	/**
	 * This is getDistance method.
	 * @return distance double type
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * This is setDistance method
	 * @param distance double type
	 */
	public void setDistance(double distance) {
		this.distance = distance; // save parameter distance to this class's distance members.
	}
	/**
	 * This is getName method.
	 * @return name string type
	 */
	public String getName() {	
		return name;
	}
	/**
	 * This is setName method
	 * @param name string type
	 */
	public void setName(String name) {
		this.name = name; // save parameter name to this class's name members.
	}
	/**
	 * This is getSales method.
	 * @return sales double type
	 */
	public double getSales() {
		return sales;
	}
	/**
	 * This is setSales method
	 * @param sales double type
	 */
	public void setSales(double sales) {
		this.sales = sales; // save parameter sales to this class's sales members.
	}


}
