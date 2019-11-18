package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreditController {

    @FXML
    private AnchorPane Credit;

    @FXML
    private Text headerText;

    @FXML
    private Text nameText;

    @FXML
    private Button mainMenuButton;

    @FXML
    void changeSceneToMainMenu(ActionEvent event) {
    	try {
        	Parent mainMenuParent = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
        	Scene mainMenuScene = new Scene(mainMenuParent);
        	
        	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
        	
        	window.setScene(mainMenuScene);
        	window.show();
        	
        	} catch (Exception e) {
    			e.printStackTrace();
    		}
    }

}
