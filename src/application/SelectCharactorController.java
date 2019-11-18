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


public class SelectCharactorController {

    @FXML
    private Button charactor1;

    @FXML
    private Button charactor2;

    @FXML
    private Button charactor3;

    @FXML
    private Button charactor4;
    @FXML
    void ToCharcator1(ActionEvent event) throws IOException {
    	try {
    	Parent CharactorParent = FXMLLoader.load(getClass().getResource("/Charactor1.fxml"));
    	Scene CharactorScene = new Scene(CharactorParent);
    	
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(CharactorScene);
    	window.show();
    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }


}
