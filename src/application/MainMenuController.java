package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private AnchorPane MainMenu;

    @FXML
    private Button startButton;

    @FXML
    private Button creditButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button settingButton;

    @FXML
    public void changeSceneToCredit(ActionEvent event) throws IOException {
    	try {
    	Parent creditParent = FXMLLoader.load(getClass().getResource("/Credit.fxml"));
    	Scene creditScene = new Scene(creditParent);
    	
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(creditScene);
    	window.show();
    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
