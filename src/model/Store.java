package model;

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

}
