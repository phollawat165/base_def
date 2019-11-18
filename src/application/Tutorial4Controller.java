package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tutorial4Controller {

    @FXML
    private Button SKIP;

    @FXML
    private Button next5;

    @FXML
    private Button back3;

    @FXML
    void BackTo3(ActionEvent event) throws IOException {
    	try {
    	Parent tutorialParent = FXMLLoader.load(getClass().getResource("/Tutorial3.fxml"));
    	Scene tutorialScene = new Scene(tutorialParent);
    	
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(tutorialScene);
    	window.show();
    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void NextTo5(ActionEvent event) throws IOException {
    	try {
    	Parent tutorialParent = FXMLLoader.load(getClass().getResource("/Tutorial5.fxml"));
    	Scene tutorialScene = new Scene(tutorialParent);
    	
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(tutorialScene);
    	window.show();
    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void skip(ActionEvent event) throws IOException {
    	try {
    	Parent CharactorParent = FXMLLoader.load(getClass().getResource("/SelectCharactor.fxml"));
    	Scene CharactorScene = new Scene(CharactorParent);
    	
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(CharactorScene);
    	window.show();
    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }


}

