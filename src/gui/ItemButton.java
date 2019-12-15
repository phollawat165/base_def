package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ItemButton extends Button {
	
	private String item;
	
	public ItemButton (String item) {
		this.setPadding(new Insets(5));
		this.setStyle("-fx-background-color: transparent; ");
		
		// TODO Completes ItemButton's constructor
		
		String url;
		switch(item) {
			case "1" : url = "spaceShips_007.png"; break;
			case "2" : url = "spaceShips_005.png"; break;
			case "3" : url = "spaceShips_006.png"; break;
			case "4" : url = "shadedDark43.png"; break;
			case "goBack" : url = "shadedDark45.png"; break;
			case "Start" : url = "shadedDark42.png"; break;
			default : url = "shadedDark12.png";
		}
		ImageView image;
		if(ClassLoader.getSystemResource(url) == null) {
			image = new ImageView(new Image("file:res/"+url));
		}
		else {
		String image_path = ClassLoader.getSystemResource(url).toString();
		    image = new ImageView(new Image(image_path));}
		image.setRotate(90);
		
		image.setFitWidth(150);
		image.setFitHeight(150);
		
		this.setGraphic(image);	
		this.item = item;
		}
	
	
	public String getItem() {
		return this.item;
	}
	
}
