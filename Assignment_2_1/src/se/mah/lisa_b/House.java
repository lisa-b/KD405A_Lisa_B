package se.mah.lisa_b;

public class House {
	 private int yearBuilt;
	 private int size;
	 private final int minSize = 10;
	 
	 public House(int yearBuilt, int size){
		 if (yearBuilt < 1800){
			 this.yearBuilt = 0;
		 }
		 else if (yearBuilt > 2015){
			 this.yearBuilt = 0;
		 }
		 else {
			 this.yearBuilt = yearBuilt;
		 }
		 
		 if (size < minSize){
			this.size = minSize;
		 }
		 else if(size > 1000) {
			 this.size = 1000;
		 }
		 else {
			this.size = size;
		 }
	 }
	 
	 public int getYearBuilt(){
		 return this.yearBuilt;
	 }
	 
	 public int getSize(){
		 return this.size;
	 }

}
