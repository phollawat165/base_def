package ScoreBoard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameStatus extends VBox {
	private Text label = new Text("STATUS");
	public static Status status;
	public GameStatus() {this.setAlignment(Pos.CENTER);
	this.setSpacing(10);
	this.setPadding(new Insets(10));
	
	
	this.label.setFill(Color.MEDIUMAQUAMARINE);
    this.label.setFont(new Font("Arial", 30));
    Glow glow = new Glow();
    glow.setLevel(10);  
    this.label.setEffect(glow);
	this.status = new Status();
	this.getChildren().addAll(label,status);
	// implement your code here
	
}


public Status getStatus() {
	return status;
}


}
