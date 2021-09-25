package ui;

import java.io.IOException;

import model.Store;

public class Main {

	public static final String DEFAULT_INPUT_PATH = "data/input/input.txt";
	public static final String DEFAULT_OUTPUT_PATH = "data/output/output.txt";
	
	private Store store;
	private StoreController controller;
	
	public Main() throws NumberFormatException, IOException {
		store = new Store(DEFAULT_INPUT_PATH);
		controller = new StoreController(store);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Main app = new Main();
		app.getStore().startSection2();
		app.getStore().startSection4(app.getStore().startSection3());
		app.getStore().generateOutput(DEFAULT_OUTPUT_PATH);
	}
	
	public Store getStore() {
		return store;
	}

}
