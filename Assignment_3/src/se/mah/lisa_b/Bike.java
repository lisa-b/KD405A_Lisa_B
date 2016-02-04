package se.mah.lisa_b;

/**
 * Bike class
 * @author lisa
 *
 */
public class Bike {
	private String _color;
	private int _price;
	private int _size;
	
	public Bike(String color, int size){
		setColor(color);
		setSize(size);
	}
	public Bike(int price, String color, int size) {
		setColor(color);
		setSize(size);
		setPrice(price);
	}
	
	public String getColor(){
		return _color;
	}
	
	public int getSize(){
		return _size;
	}
	
	public int getPrice(){
		return _price;
	}
	
	public void setPrice(int price){
		if(price>=Constants.MIN_PRICE && price<=Constants.MAX_PRICE){
			_price = price;		
		} else {
			_price = Constants.MIN_PRICE;
		}	
	}
	
	public void setSize(int size){
		if(size>=Constants.MIN_SIZE && size<=Constants.MAX_SIZE){
			_size = size;	
		} else {
			_size = Constants.MIN_SIZE;
		}
	}
	
	public void setColor(String color){
		for(int i = 0; i<Constants.COLOR.length; i++){
			if (Constants.COLOR[i].equals(color)){
				_color = color;
			}
		}
	}
	

}
