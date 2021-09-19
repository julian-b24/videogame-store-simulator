package model;

import java.util.ArrayList;

import datastructure.Stack;

public class Client implements Comparable<Client>{

	private int time;
	private String id;
	private ArrayList<String> list;
	private Stack<Game> basket;
	
	public Client(int time, String id, ArrayList<String> list) {
		this.time = time;
		this.id = id;
		this.list = list;
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

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
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
