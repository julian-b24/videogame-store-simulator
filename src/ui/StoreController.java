package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Store;

public class StoreController {

	private Store store;
	
	@FXML
    private GridPane mainPane;
	
	@FXML
	private TextField txtFileSearch;

    @FXML
    private Text txtSuccessMessage;
	    
	public StoreController(Store store) {
		this.store = store;
	}
	
	
    @FXML
    public void browse(ActionEvent event) {

    }

    @FXML
    public void importEntry(ActionEvent event) {

    }
    
    public void loadSelectFile() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("select-file.fxml"));
		fxmlLoader.setController(this);
		Parent selectFile = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(selectFile);
    }
}
