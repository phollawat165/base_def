package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController{

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
    
    public Stage window = new Stage();
    
    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

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
    
    @FXML
    void changeSceneToExit() {
    	try {
        	Parent exitParent = FXMLLoader.load(getClass().getResource("/ExitConfirmation.fxml"));
        	Scene exitScene = new Scene(exitParent);
        	
        	window.setScene(exitScene);
        	window.setTitle("Exit Base Defence?");
//        	window.initModality(Modality.APPLICATION_MODAL);
        	
        	window.showAndWait();
        
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void closeExitConfirmationScene(ActionEvent event) {
    	// get a handle to the stage
    	  Stage stage = (Stage) noButton.getScene().getWindow();
    	  // do what you have to do
    	  stage.close();
    }

    @FXML
    void closeApplication(ActionEvent event) {
    	Platform.exit();
    }
    @FXML
    void toTutorial(ActionEvent event) throws IOException {
    	try {
    	Parent tutorialParent = FXMLLoader.load(getClass().getResource("/Tutorial1.fxml"));
    	Scene tutorialScene = new Scene(tutorialParent);
    	
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(tutorialScene);
    	window.show();
    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
