package se.mah.lisa_b;

public class Human {
	private Dog dog;
	private String name;
	
	public Human(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void buyDog(Dog dog){
		this.dog = dog;
	}
	/**Returnerar: "x äger en hund som heter y" eller " x äger inte en hund"*/ 
	public String getInfo(){
		if (dog != null){
			return this.name + " äger en hund som heter " + this.dog.name;
		}
		else{
			return this.name + " äger inte en hund";	
		}
		
	}
}
