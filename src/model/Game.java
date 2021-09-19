package model;

public class Game implements Comparable<Game>{

	private String code;
	private int price;
	private Shelf shelf;
	
	public Game(String code, int price, Shelf shelf) {
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

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	@Override
	public int compareTo(Game o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
