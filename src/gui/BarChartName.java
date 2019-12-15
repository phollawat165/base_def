package gui;

import javafx.geometry.Insets;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BarChartName {
	private VBox pane;
	private Text text1 = new Text("            HEALTH");
	private Text text2 = new Text("         FIRERATE");
	private Text text3 = new Text("BULLET SPEED");
	private Text text4 = new Text("      TOP SPEED");
	public BarChartName() {
		pane = new VBox();
		this.pane.setPadding(new Insets(10));
		this.pane.setSpacing(6);
		
		text1.setFill(Color.MEDIUMAQUAMARINE);
	    text1.setFont(new Font("Arial", 20));
	    
	    text2.setFill(Color.MEDIUMAQUAMARINE);
	    text2.setFont(new Font("Arial", 20));
	    
	    text3.setFill(Color.MEDIUMAQUAMARINE);
	    text3.setFont(new Font("Arial", 20));
	    
	    text4.setFill(Color.MEDIUMAQUAMARINE);
	    text4.setFont(new Font("Arial", 20));
	    
	    
	    pane.getChildren().addAll(text1,text2,text3,text4);
		
	}
	 public VBox getPane() {
		   return pane;
	   }
}
