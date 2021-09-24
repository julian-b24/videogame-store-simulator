package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Store;

public class StoreController {

	private Store store;
	
	@FXML
    private TextField txtFileSearch;

	public StoreController(Store store) {
		this.store = store;
	}
	
	
    @FXML
    void browse(ActionEvent event) {

    }

    @FXML
    void importEntry(ActionEvent event) {

    }
}
