package se.mah.lisa_b;

import java.util.Random;

public class Uppgift_4 {

	public static void main(String[] args) {
		System.out.println("Uppgift 4");
		
		BikeStore store = new BikeStore();
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++){
			store.addBike(Constants.COLOR[rand.nextInt(3)], rand.nextInt(21)+8, rand.nextInt(30001));					
		}
		
		System.out.println(store.getAllBikes());
	}

}
