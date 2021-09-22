package model;

import java.util.ArrayList;
import java.util.HashMap;

import datastructure.HashTable;
import datastructure.Queue;

public class Store {

	private HashTable<String, Shelf> shelfs;
	private Queue<Client> clients;
	private Cashier[] cashiers;
	private HashTable<String, Game> games;
	
	public Store(HashTable<String, Shelf> shelfs, Queue<Client> clients, int cashierAmount) {
		this.shelfs = shelfs;
		this.clients = clients;
		cashiers = new Cashier[cashierAmount];
	}

	
	
	//Section 3 actions
	//Start the process of section 3
	public void startSection3() {
		
		ArrayList<Client> passedClients = new ArrayList<>();
		
		while (!clients.isEmpty()) {
			pickUpGames(clients.front());
			passedClients.add(clients.front());
			clients.dequeue();
		}
	}
	
	//Executes the pick up process of a client based on the games list
	public void pickUpGames(Client client) {
		for (String code : client.getGameList()) {
			Game game = games.get(code);
			//Add the game to the basket
			client.getBasket().push(game);
			//Remove one unit of the game from the shelf
			shelfs.get(game.getShelf().getName()).getGames(); //UNCOMPLETE
			
		}
	}
	
	public HashTable<String, Shelf> getShelfs() {
		return shelfs;
	}

	public void setShelfs(HashTable<String, Shelf> shelfs) {
		this.shelfs = shelfs;
	}

	public Queue<Client> getClients() {
		return clients;
	}

	public void setClients(Queue<Client> clients) {
		this.clients = clients;
	}

	public Cashier[] getCashiers() {
		return cashiers;
	}

	public void setCashiers(Cashier[] cashiers) {
		this.cashiers = cashiers;
	}

	public HashTable<String, Game> getGames() {
		return games;
	}

	public void setGames(HashTable<String, Game> games) {
		this.games = games;
	}

}
