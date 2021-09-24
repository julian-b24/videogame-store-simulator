package model;

import java.util.ArrayList;

import datastructure.HashTable;
import datastructure.Queue;

public class Store {

	private HashTable<String, Shelf> shelfs;
	private Queue<Client> clients;
	private Cashier[] cashiers;
	private HashTable<String, Game> games;
	private ArrayList<Client> finalClientList = new ArrayList<Client>();
	private ArrayList<Integer> finalPriceList = new ArrayList<Integer>();
	
	public Store(HashTable<String, Shelf> shelfs, Queue<Client> clients, int cashierAmount) {
		this.shelfs = shelfs;
		this.clients = clients;
		cashiers = new Cashier[cashierAmount];
	}

	//Section 3 actions
	//Start the process of section 3
	public ArrayList<Client> startSection3() {

		ArrayList<Client> passedClients = new ArrayList<>();

		while (!clients.isEmpty()) {
			pickUpGames(clients.front());
			passedClients.add(clients.front());
			clients.dequeue();
		}
		return passedClients;
	}

	//Executes the pick up process of a client based on the games list
	public void pickUpGames(Client client) {
		for (String code : client.getGameList()) {
			Game game = games.get(code);
			Shelf shelf = shelfs.get(game.getShelf().getName());
			int amount = shelf.getGames().get(code);
			if(amount > 0) {
				//Add the game to the basket
				client.getBasket().push(game);
				//Remove one unit of the game from the shelf
				shelf.getGames().set(code, amount - 1);
				//Increase time of client
				client.setTime(client.getTime() + 1);
			}
		}
	}

	public void startSection4(ArrayList<Client> passedClients) {
		sortClientList(passedClients);
		for(int i = 0; i < passedClients.size(); i++) {
			clients.enqueue(passedClients.get(i));
		}
		cashierSlots();
	}

	//Insertion implementation.
	public static void sortClientList(ArrayList<Client> passedClients) {
		for(int i = 1; i < passedClients.size(); i++) {
			Client key = passedClients.get(i);
			for(int j = i-1; j>=0 && key.getTime() < passedClients.get(j).getTime(); j--) {
				Client temp = passedClients.get(j);
				passedClients.set(j, key);
				passedClients.set(i, temp);
			}
		}
	}
	
	//Simulates the cashier slots process.
	public void cashierSlots() {
		
		ArrayList<Client> cashierSlots = new ArrayList<Client>(cashiers.length);
		Client actualClient;
		
		while(!clients.isEmpty() || !cashierSlots.isEmpty()) {
			
			/*
			It adds a client to the available slots from the client queue.
			After that, it starts iterating until the client's games are fully packaged. 
			Only then the client finishes the process.
			*/
			
			for(int i = 0; i < cashiers.length; i++) {
				if(cashierSlots.get(i) == null) {
					cashierSlots.set(i, clients.front());
					clients.dequeue();
				}
				
				actualClient = cashierSlots.get(i);
				
				cashiers[i].getGames().push(actualClient.getBasket().top());
				cashiers[i].setBill(cashiers[i].getBill() + actualClient.getBasket().top().getPrice());
				actualClient.getBasket().pop();
				
				if(actualClient.getBasket().isEmpty()) {
					finalClientList.add(actualClient);
					finalPriceList.add(cashiers[i].getBill());
					cashierSlots.set(i, null);
					cashiers[i].setBill(0);
				}
				
			}
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
