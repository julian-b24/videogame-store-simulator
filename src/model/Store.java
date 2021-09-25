package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import datastructure.HashTable;
import datastructure.Queue;
import datastructure.Stack;

public class Store {

	private HashTable<String, Shelf> shelfs;
	private Queue<Client> clients;
	private Cashier[] cashiers;
	private HashTable<String, Game> games;
	private ArrayList<Client> finalClientList = new ArrayList<Client>();
	private ArrayList<Integer> finalPriceList = new ArrayList<Integer>();
	private int clientsInStore;		//amount of clients in the store; used for time
	
	public Store(String inputFile) throws NumberFormatException, IOException {
		shelfs = new HashTable<String, Shelf>();
		games = new HashTable<String, Game>();
		clients = new Queue<Client>();
		clientsInStore = 0;
		readInput(inputFile);
	}

	//Section 2 actions
		//Start the process of section 2
		public void startSection2() {
			//Receive a list with the codes of each game
			ArrayList<Client> passedClients = new ArrayList<>();
			while(!clients.isEmpty()) {
				getAvailableGameList(clients.front());
				passedClients.add(clients.front());
				clients.dequeue();
			}
			for (int i = 0; i < passedClients.size(); i++) {
				clients.enqueue(passedClients.get(i));
			}
		}
		
		//This method has complexity analysis in document
		private void getAvailableGameList(Client client) {
			ArrayList<String> availableGames = new ArrayList<>();
			//search for each game in the clients game list, then ordered by shelfs
			for (int i = 0; i < client.getGameList().size(); i++) {
				String codeGameX = client.getGameList().get(i);
				//verify that the game is in the store
				if(games.containsKey(codeGameX)) {
					//get the game object from the store based on its code
					Game gameX = games.get(codeGameX);
					
					//get the shelf where the game is
					String shelfContainerName = gameX.getShelf().getName();
					
					//verify that there are still available copies
					if(shelfs.get(shelfContainerName).getGames().get(codeGameX)>0) {
						availableGames.add(gameX.getCode());
					}
				}
			}
			
			ArrayList<String> clientOrderedGames = orderGamesByShelf(availableGames);
			client.setGameList(clientOrderedGames);
		}

		//This method has complexity analysis in document
		private ArrayList<String> orderGamesByShelf(ArrayList<String> availableGames) {
			String l = "";
			ArrayList<String> finalLsit = new ArrayList<>();
			for (int i = 0; i < availableGames.size(); i++) {
				l += games.get(availableGames.get(i)).getShelf().getName();
			}
			char[] aGames = l.toCharArray();
			
			 int n = aGames.length;
		        for (int i = 0; i < n-1; i++)
		            for (int j = 0; j < n-i-1; j++)
		                if (aGames[j] >= aGames[j+1])
		                {
		                    char temp = aGames[j];
		                    aGames[j] = aGames[j+1];
		                    aGames[j+1] = temp;
		                    
		                    String tempCode = availableGames.get(j);
		                    availableGames.set(j, availableGames.get(j + 1));
		                    availableGames.set(j + 1, tempCode);
		                    
		                }
		        for (int i = 0; i < aGames.length; i++) {
					finalLsit.add(aGames[i]+"");
				}
			return availableGames;
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
		
		ArrayList<Client> cashierSlots = new ArrayList<Client>();
		for (int i = 0; i < cashiers.length ; i++) {
			cashierSlots.add(null);
			cashiers[i] = new Cashier();
		}
		Client actualClient;
		
		int count = 3;
		while(!clients.isEmpty() || count != 0) {
			
			/*
			It adds a client to the available slots from the client queue.
			After that, it starts iterating until the client's games are fully packaged. 
			Only then the client finishes the process.
			*/
			
			for(int i = 0; i < cashiers.length; i++) {
				if(cashierSlots.get(i) == null && !clients.isEmpty() ) {
					cashierSlots.set(i, clients.front());
					clients.dequeue();
				}
				if(cashierSlots.get(i) != null) {
					actualClient = cashierSlots.get(i);
					//actualClient = cashierSlots.get(i);
					cashiers[i].getGames().push(actualClient.getBasket().top());
					cashiers[i].setBill(cashiers[i].getBill() + actualClient.getBasket().top().getPrice());
					actualClient.getBasket().pop();
					
					if(actualClient.getBasket().isEmpty()) {
						retrieveGamesToClient(cashiers[i].getGames(), actualClient.getBasket());
						finalClientList.add(actualClient);
						finalPriceList.add(cashiers[i].getBill());
						cashierSlots.set(i, null);
						cashiers[i].setBill(0);
					}
				}	
			}
			
			count = 0;
			for (int i = 0; i < cashierSlots.size(); i++) {
				if(cashierSlots.get(i) != null) {
					count++;
				}
			}
		}
	}
	
	private void retrieveGamesToClient(Stack<Game> cashierStack, Stack<Game> clientStack) {
		while(!cashierStack.isEmpty()) {
			clientStack.push(cashierStack.top());
			cashierStack.pop();
		}
	}
	
	private void readInput(String fileName) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		int cases = Integer.valueOf(br.readLine());
		while(cases > 0) {
			int amountCashiers = Integer.valueOf(br.readLine());
			cashiers = new Cashier[amountCashiers];
			
			int amountShelfs = Integer.valueOf(br.readLine());
			while(amountShelfs > 0) {
				String[] line = br.readLine().split(" ");
				String shelfName = line[0];
				int gamesInShelf = Integer.valueOf(line[1]);
				
				Shelf shelf = new Shelf(shelfName);
				while(gamesInShelf > 0) {
					
					String[] gameLine = br.readLine().split(" ");
					String code = gameLine[0];
					int price = Integer.valueOf(gameLine[1]);
					int units = Integer.valueOf(gameLine[2]);
					
					Game game = new Game(code, price, shelf);
					shelf.getGames().add(code, units);
					games.add(code, game);
					
					gamesInShelf--;
				}
				
				shelfs.add(shelfName, shelf);
				amountShelfs--;
			}
			
			int amountClients = Integer.valueOf(br.readLine());
			while(amountClients > 0) {
				String[] clientLine = br.readLine().split(" ");
				String id = clientLine[0];
				ArrayList<String> gameList = new ArrayList<String>();
				for (int i = 1; i < clientLine.length; i++) {
					String gameCode = clientLine[i];
					gameList.add(gameCode);
				}
				
				Client client = new Client(clientsInStore + 1, id, gameList);
				clientsInStore++;
				clients.enqueue(client);
				amountClients--;
			}
			
			cases--;
		}
		br.close();
	}
	
	public void generateOutput(String fileName) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String message = "";
		for(int i = 0; i < finalClientList.size(); i++) {
			message += finalClientList.get(i).getId() + " " + finalPriceList.get(i) + "\n";
			message += basketOutput(finalClientList.get(i).getBasket()) + "\n";
		}
		bw.write(message);
		bw.close();
	}
	
	public String basketOutput(Stack<Game> stack) {
		String output = "";
		while(!stack.isEmpty()) {
			output += stack.top().getCode() + " ";
			stack.pop();
		}
		return output;
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
