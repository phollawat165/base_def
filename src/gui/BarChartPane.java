package gui;

import static javafx.scene.layout.BorderStrokeStyle.SOLID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.chart.XYChart.Series;


public class BarChartPane  {

	private VBox pane = new VBox();
	private int number;
	private int r1;
	private int r2;
	private int r3;
	private int r4;
	
	
	public BarChartPane (int number) {
		this.number = number;
		setStat(number);
		
		this.pane.setPadding(new Insets(10));
		this.pane.setSpacing(10);
		Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(r1);
        rectangle1.setHeight(20);
        rectangle1.setFill(Color.CYAN);
        
        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(r2);
        rectangle2.setHeight(20);
        rectangle2.setFill(Color.CYAN);
        
        Rectangle rectangle3 = new Rectangle();
        rectangle3.setWidth(r3);
        rectangle3.setHeight(20);
        rectangle3.setFill(Color.CYAN);
        
        Rectangle rectangle4 = new Rectangle();
        rectangle4.setWidth(r4);
        rectangle4.setHeight(20);
        rectangle4.setFill(Color.CYAN);
        

		String url = "scaleHori.png";
        
        ImageView image1;
		if(ClassLoader.getSystemResource(url) == null) {
			image1 = new ImageView(new Image("file:res/"+url));
		}
		else {
		String image_path = ClassLoader.getSystemResource(url).toString();
		    image1 = new ImageView(new Image(image_path));}
        image1.setFitHeight(10);
        image1.setFitWidth(200);
        
        ImageView image2;
        if(ClassLoader.getSystemResource(url) == null) {
			image2 = new ImageView(new Image("file:res/"+url));
		}
		else {
		String image_path = ClassLoader.getSystemResource(url).toString();
		    image2 = new ImageView(new Image(image_path));}
        image2.setFitHeight(10);
        image2.setFitWidth(200);
        image2.setRotate(180.0);
       
        
        
        pane.getChildren().addAll(image1,rectangle1,rectangle2,rectangle3,
        		rectangle4,image2);
        
		// TODO Implements BarChartPane's contructor
		
		
	}
	   public VBox getPane() {
		   return pane;
	   }
	   public void setStat(int number) {
		   switch(number) {
			case 1 : r1=100;r2=150;r3=120;r4=140; break;
			case 2 : r1=60;r2=200;r3=200;r4=160; break;
			case 3 : r1=200;r2=100;r3=100;r4=120; break;
			default : r1=100;r2=100;r3=100;r4=100;
		   
	   }
		   
	   }
	   public void rotate(Double arc) {
		   this.pane.setRotate(arc);
	   }
	
	
}
