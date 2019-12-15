package ScoreBoard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score extends VBox{
	private Text label = new Text("SCORE");
	private DisplayPart displayPart;
	// implement your code here
	

	public Score() {
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		
		
		this.label.setFill(Color.MEDIUMAQUAMARINE);
	    this.label.setFont(new Font("Arial", 30));
	    Glow glow = new Glow();
	    glow.setLevel(10);  
	    this.label.setEffect(glow);
		this.displayPart = new DisplayPart();
		this.getChildren().addAll(label,displayPart);
		// implement your code here
		
	}
	
	public String getName() {
		return label.getText().trim();
		// implement your code here	
	}
	
	public DisplayPart getDisplayPart() {
		return displayPart;
	}
	
	
	
	// Generate getters 
	
	
}
