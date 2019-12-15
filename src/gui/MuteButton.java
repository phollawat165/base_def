package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MuteButton extends Button {
	private ImageView image;
	public MuteButton() {
		this.setStyle(
                "-fx-background-color: transparent;"+
                "-fx-border-radius: 40em; " +
                "-fx-max-width: 60px; " +
                "-fx-max-height: 60px;"+"-fx-border-color:cyan");
        StackPane.setAlignment(this, Pos.TOP_LEFT);
        String url = "beat1.png";
		if(ClassLoader.getSystemResource(url) == null) {
			image = new ImageView(new Image("file:res/"+url));
		}
		else {
		String image_path = ClassLoader.getSystemResource(url).toString();
		    image = new ImageView(new Image(image_path));}
		image.setFitHeight(40);
		image.setFitWidth(40);
		this.setGraphic(image);
        
		// TODO Auto-generated constructor stub
	}
	
	
}

