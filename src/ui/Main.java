package ui;

import java.io.IOException;

import model.Store;

public class Main {

	public static final String DEFAULT_INPUT_PATH = "data/input/input.txt";
	
	private Store store;
	//private StoreController controller;
	
	public Main() throws NumberFormatException, IOException {
		store = new Store(DEFAULT_INPUT_PATH);
	}
	
	
	public static void main(String[] args) {
		
	}

}
