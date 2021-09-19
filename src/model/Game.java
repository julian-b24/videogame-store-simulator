package model;

public class Game {

	private String code;
	private int price;
	private String shelf;	//Type String or Shelf?
	
	public Game(String code, int price, String shelf) {
		this.code = code;
		this.price = price;
		this.shelf = shelf;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	
}
