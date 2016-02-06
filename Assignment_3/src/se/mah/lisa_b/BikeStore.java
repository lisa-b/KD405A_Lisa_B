package se.mah.lisa_b;

import java.util.ArrayList;

/**
 * BikeStore class with an arraylist of bikes
 * @author Lisa Bolmsten
 *
 */
public class BikeStore {

	private ArrayList<Bike> bikes = new ArrayList<Bike>();
	
	/**
	 * Get all bikes currently in the store as a formatted string.
	 * @return formatted string
	 */
	public String getAllBikes(){
		String cyklar = new String();
		for(Bike cykel: bikes){
			cyklar = cyklar + "Pris: " + cykel.getPrice() + " Färg: " + cykel.getColor() + " Storlek: " + cykel.getSize() + "\n";	
		}
		return cyklar;
	}
	
	/**
	 * Add a new bike to the store.
	 * @param color
	 * @param size
	 * @param price
	 */
	public void addBike(String color, int size, int price){
		bikes.add(new Bike(price, color, size));
	}
		
}
