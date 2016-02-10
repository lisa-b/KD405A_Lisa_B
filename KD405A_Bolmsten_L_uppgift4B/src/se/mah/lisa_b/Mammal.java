package se.mah.lisa_b;

public abstract class Mammal extends Animal {
	private int gestationTime;

	public Mammal(String latinName, int gestationTime) {
		super(latinName);
		this.gestationTime = gestationTime;
	}

	public int getGestationtime(){
		return this.gestationTime;
	}


}
