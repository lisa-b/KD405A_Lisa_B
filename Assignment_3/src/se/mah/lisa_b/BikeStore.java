package se.mah.lisa_b;

import java.util.ArrayList;

public class BikeStore {

	private ArrayList<Bike> bikes = new ArrayList<Bike>();
	
	public String getAllBikes(){
		String cyklar = new String();
		for(Bike cykel: bikes){
			cyklar = cyklar + "Pris: " + cykel.getPrice() + " Färg: " + cykel.getColor() + " Storlek: " + cykel.getSize() + "\n";	
		}
		return cyklar;
	}
	public void addBike(String color, int size, int price){
		bikes.add(new Bike(price, color, size));
	}
		
}
