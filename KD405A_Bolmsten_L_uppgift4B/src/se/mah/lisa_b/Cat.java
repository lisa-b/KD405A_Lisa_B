package se.mah.lisa_b;

public class Cat extends Mammal {
	int numberOfLives;

	public Cat(String latinName, int gestationTime, int numberOfLives) {
		super(latinName, gestationTime);
		this.setNumberOfLives(numberOfLives);
	}

	@Override
	public String getInfo() {
		String info = new String();
		
		info = "The cat " + this.getFriendlyName() + " lat: " + this.getLatinName() + " nurses for " + this.getGestationtime() + " months and has " + this.getNumberOfLives() + " lives";

		return info;
	}
	
	public void setNumberOfLives(int i){
		this.numberOfLives = i;
	}

	public int getNumberOfLives() {
		return this.numberOfLives;
	}

}
