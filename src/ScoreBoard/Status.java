package ScoreBoard;

import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Status extends Text {
	public static int statusInt = 1;
	public  Status() {
		this.setFill(Color.MEDIUMAQUAMARINE);
	    this.setFont(new Font("Arial", 15));
	    Glow glow = new Glow();
	      glow.setLevel(10);  
	      
	      this.setEffect(glow);
		// implement your code here
		
	}
	
	public void update(int textnumber) {
		String text;
		switch(textnumber) {
		case 1 : text = "";
			break;
		case 2 : text = "YOUR GAUGE\nNOT REACH\nYET";
		   break;
		case 3 : text = "YOUR HP\nIS FULL";
		   break;
		case 4 : text = "YOUR GAUGE\nIS FULL";
		   break;
		case 5 : text = "HEAL";
		   break;
		default : text = "ACTIVATE";}
		this.setText(text);
		// implement your code here
		
	}
}
