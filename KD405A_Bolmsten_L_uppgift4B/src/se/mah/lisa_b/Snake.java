package se.mah.lisa_b;

public class Snake extends Animal {
	boolean poisonus;

	public Snake(String latinName, boolean poisonus) {
		super(latinName);
		this.poisonus = poisonus;
	}

	@Override
	public String getInfo() {
		String info = new String();
		
		info = "The snake named " + this.getFriendlyName() + " lat: " + this.getLatinName();
		
		if (this.isPoisonus()) {
			info = info + " is poisonus";
		}
		else {
			info = info + " is not poisonus";
		}
		return info;
	}
	
	public boolean isPoisonus(){
		return this.poisonus;
	}

}
