package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Store;

public class Main extends Application{

	public static final String DEFAULT_INPUT_PATH = "data/input/input.txt";
	public static final String DEFAULT_OUTPUT_PATH = "data/output/output.txt";
	
	private Store store;
	private StoreController controller;
	
	public Main() throws NumberFormatException, IOException {
		store = new Store(DEFAULT_INPUT_PATH);
		controller = new StoreController(store);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		launch(args);
		/*Main app = new Main();
		app.getStore().startSection2();
		app.getStore().startSection4(app.getStore().startSection3());
		app.getStore().generateOutput(DEFAULT_OUTPUT_PATH);*/
	}
	
	public Store getStore() {
		return store;
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Game Store Simulator");
		primaryStage.show();
		
		controller.loadSelectFile();
	}

}
