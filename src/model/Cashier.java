package model;

import datastructure.Stack;

public class Cashier {

	private Stack<Game> games;
	private int bill;
	
	public Cashier() {
		games = new Stack<Game>();
		bill = 0;
	}

	public Stack<Game> getGames() {
		return games;
	}

	public void setGames(Stack<Game> games) {
		this.games = games;
	}
	
	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}
	
}
