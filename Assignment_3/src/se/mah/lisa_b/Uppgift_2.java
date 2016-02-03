package se.mah.lisa_b;

import java.util.ArrayList;
import java.util.Random;

public class Uppgift_2{

	public static void main(String[] args) {
		System.out.println("Uppgift 2");
		
		Random rand = new Random();
		ArrayList<Bike> cyklarna = new ArrayList<Bike>();
		
		for(int i = 0; i < 10; i++){
			cyklarna.add(new Bike(rand.nextInt(30001), Constants.COLOR[rand.nextInt(3)], rand.nextInt(21)+8));
		}
		
		for(Bike cykel: cyklarna){
			System.out.println("Pris: " + cykel.getPrice() + " Färg: " + cykel.getColor() + " Storlek: " + cykel.getSize());
		}
	}
	
}
