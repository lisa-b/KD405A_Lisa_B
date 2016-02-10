package se.mah.lisa_b;

public class Dog extends Mammal {
	boolean stupid;

	public Dog(String latinName, int gestationTime, boolean stupid) {
		super(latinName, gestationTime);
		this.stupid = stupid;
	}

	public Dog(String latinName, int gestationTime, boolean stupid, String friendlyName) {
		super(latinName, gestationTime);
		this.setFriendlyName(friendlyName);
		this.stupid = stupid;
	}

	@Override
	public String getInfo() {
		String info = new String();
		
		info = "The dog named " + this.getFriendlyName() + " lat: " + this.getLatinName() + " nurses for " + this.getGestationtime() + " months"; //TODO testa med super.latinName
		
		if (this.isStupid()) {
			info = info + " and is stupid";
		}
		else {
			info = info + " and is not stupid";
		}
		return info;
	}
	
	public boolean isStupid(){
		return this.stupid;
	}

}