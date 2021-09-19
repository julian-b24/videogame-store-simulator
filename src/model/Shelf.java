package model;

import datastructure.HashTable;

public class Shelf {

	private String name;
	private HashTable<String, Integer> games;
	
	public Shelf(String name){
		this.name = name;
		games = new HashTable<String, Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashTable<String, Integer> getGames() {
		return games;
	}

	public void setGames(HashTable<String, Integer> games) {
		this.games = games;
	}

}
