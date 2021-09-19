package model;

import java.util.ArrayList;

import datastructure.Stack;

public class Client implements Comparable<Client>{

	private int time;
	private String id;
	private ArrayList<String> gameList;
	private Stack<Game> basket;
	
	public Client(int time, String id, ArrayList<String> gameList) {
		this.time = time;
		this.id = id;
		this.gameList = gameList;
		setBasket(new Stack<Game>());
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public ArrayList<String> getGameList() {
		return gameList;
	}

	public void setGameList(ArrayList<String> gameList) {
		this.gameList = gameList;
	}

	public Stack<Game> getBasket() {
		return basket;
	}

	public void setBasket(Stack<Game> basket) {
		this.basket = basket;
	}
	
	@Override
	public int compareTo(Client o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
