package ScoreBoard;


import static javafx.scene.layout.BorderStrokeStyle.SOLID;

import Object.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class GameBar extends VBox{
//	private Text labelHP = new Text("HP");
	private Text labelGA = new Text("GAUGE");
//	private HPbar hpbar;
	private GaugeBar gaugebar;
	// implement your code here
	

	public GameBar() {
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		
		
//		this.labelHP.setFill(Color.MEDIUMAQUAMARINE);
//	    this.labelHP.setFont(new Font("Arial", 30));
	    this.labelGA.setFill(Color.MEDIUMAQUAMARINE);
	    this.labelGA.setFont(new Font("Arial", 30));
	    Glow glow = new Glow();
	    glow.setLevel(10);  
//	    this.labelHP.setEffect(glow);
	    this.labelGA.setEffect(glow);
//		this.hpbar = new HPbar();
		this.gaugebar = new GaugeBar();
		this.getChildren().addAll(labelGA,gaugebar);
		// implement your code here
		
	}
	
	
//	public HPbar getHpBar() {
//		return hpbar;
//	}
	public GaugeBar getGaugeBar() {
		return gaugebar;
	}
}
