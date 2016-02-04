package se.mah.lisa_b;

/**
 * Bike class
 * @author Lisa Bolmsten
 *
 */
public class Bike {
	private String _color;
	private int _price;
	private int _size;

	/**
	 * Contructor for creating a new bike.
	 * @param color
	 * @param size
	 */
	public Bike(String color, int size){
		setColor(color);
		setSize(size);
	}
	
	/**
	 * Constructor for creating a new bike.
	 * @param price
	 * @param color
	 * @param size
	 */
	public Bike(int price, String color, int size) {
		setColor(color);
		setSize(size);
		setPrice(price);
	}
	
	/**
	 * Get color of the bike.
	 * @return color
	 */
	public String getColor(){
		return _color;
	}
	
	/**
	 * Get size of the bike.
	 * @return size
	 */
	public int getSize(){
		return _size;
	}
	
	/**
	 * Get price of the bike.
	 * @return price
	 */
	public int getPrice(){
		return _price;
	}
	
	/**
	 * Set price of the bike, limited by MIN_PRICE and MAX_PRICE constants.
	 * @param price
	 */
	public void setPrice(int price){
		if(price>=Constants.MIN_PRICE && price<=Constants.MAX_PRICE){
			_price = price;		
		} else {
			_price = Constants.MIN_PRICE;
		}	
	}
	
	/**
	 * Set size of the bike, limited by MIN_SIZE and MAX_SIZE constants.
	 * @param size
	 */
	public void setSize(int size){
		if(size>=Constants.MIN_SIZE && size<=Constants.MAX_SIZE){
			_size = size;	
		} else {
			_size = Constants.MIN_SIZE;
		}
	}
	
	/**
	 * Set color of the bike, limited by values in COLOR constant.
	 * @param color
	 */
	public void setColor(String color){
		for(int i = 0; i<Constants.COLOR.length; i++){
			if (Constants.COLOR[i].equals(color)){
				_color = color;
			}
		}
	}
	

}
