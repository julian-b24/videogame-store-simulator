package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import model.Store;

public class StoreController {

	public static final String DEFAULT_OUTPUT_PATH = "data/output/output.txt";
	
	public static final String DEFAULT_STATE_PATH = "data/output/state.txt";
	
	private Store store;
	
	@FXML
    private VBox mainPane;
	
	@FXML
	private TextField txtFileSearch;

    @FXML
    private Text txtSuccessMessage;
	    
	public StoreController(Store store) {
		this.store = store;
	}
	
	
    @FXML
    public void browse(ActionEvent event) {

    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Search input");
    	File inputFile = fileChooser.showOpenDialog(null);
    	if(inputFile != null) {
    		txtFileSearch.setText(inputFile.getAbsolutePath());
    	}
    }

    @FXML
    public void importEntry(ActionEvent event) throws IOException {
    	store.startSection2();
    	store.startSection4(store.startSection3());
    	store.generateOutput(DEFAULT_OUTPUT_PATH);
    	store.generateStateOutput(DEFAULT_STATE_PATH);
    	txtSuccessMessage.setVisible(true);
    }
    
    public void loadSelectFile() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("select-file.fxml"));
		fxmlLoader.setController(this);
		Parent selectFile = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(selectFile);
    }
}
