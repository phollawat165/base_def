package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public interface SceneChanger {
	public AnchorPane getPane();
	public void createScene();
	public Scene getScene();
	public void setUpAddButtonEvent(Button addButton,int k);
}
