package ScoreBoard;

import Object.Player;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HPbar extends Text {
	
	
	public HPbar() {
		this.setFill(Color.MEDIUMAQUAMARINE);
	    this.setFont(new Font("Arial", 30));
	    Glow glow = new Glow();
	      glow.setLevel(10);  
	      
	      this.setEffect(glow);
		// implement your code here
		
	}
	
	public void update(String text) {
		this.setText(text);
		// implement your code here
		
	}
	
}