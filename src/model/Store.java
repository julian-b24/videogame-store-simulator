package model;

import java.util.ArrayList;

import datastructure.HashTable;
import datastructure.Queue;

public class Store {

	private HashTable<String, Shelf> shelfs;	//Check this suggestion
	private Queue<Client> clients;
	private Cashier[] cashiers;
	private HashTable<String, Game> games;		//Check this suggestion
	
	//This is one way of how we could define the parameters, this is just a provisional implementation
	public Store(HashTable<String, Shelf> shelfs, Queue<Client> clients, int amountCashiers, HashTable<String, Game> games) {
		this.shelfs = shelfs;
		this.clients = clients;
		cashiers = new Cashier[amountCashiers];
		this.games = games;
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
