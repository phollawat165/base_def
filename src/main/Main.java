package main;


import java.io.IOException;



import gui.tutorial;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import gui.Background;
import gui.MuteButton;
import gui.Song;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Song song = new Song(1);
		// TODO Implement Main
		Text text1 = new Text(" START");
		Text name = new Text("            \n\nBASE DEFENCE");
		Text exit = new Text("EXIT");
		
		MuteButton mute = new MuteButton();
		
	
	      text1.setFill(Color.PALETURQUOISE);
	      
	      text1.setFont(new Font("Arial", 26));
	      
	      name.setFill(Color.PALETURQUOISE);
	      
	      name.setFont(new Font("Arial", 28));
	      
	      exit.setFill(Color.WHITE);
	      
	      exit.setFont(new Font("Arial", 24));
	      
	      exit.setX(400);
	      exit.setY(500);
	      Button Exit = new Button();
	      Exit.setGraphic(exit);
	      Exit.setPrefHeight(120);
	      
	      Glow glow = new Glow();
	   
	      glow.setLevel(40);  
	      
	      text1.setEffect(glow);
	      name.setEffect(glow);
	      exit.setEffect(glow);
	      StackPane.setAlignment(name, Pos.TOP_CENTER);
        
		StackPane root = new StackPane();
		
		
		Button start = new Button();
		start.setGraphic(text1);
		start.setPadding(new Insets(10));
		Exit.setOnAction(e -> Platform.exit());
		setUpAddButtonEvent(start,1);
		setUpAddButtonEvent(mute, 0);
		StackPane.setAlignment(start, Pos.CENTER);
		StackPane.setAlignment(Exit, Pos.BOTTOM_CENTER);
		StackPane.setAlignment(mute, Pos.TOP_LEFT);
		
		start.setStyle("-fx-background-color: transparent; ");
		Exit.setStyle("-fx-background-color: transparent; ");
		
		
		
		
		start.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			    	      
			    	      text1.setFont(new Font("Arial", 30));
			    	      
			    	      Glow glow = new Glow();   
			    	      glow.setLevel(40);  
			    	      
			    	      text1.setEffect(glow);
			    
			          }
			        });

		start.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  
			    	      
			    	      text1.setFont(new Font("Arial", 26));
			    	      
			    	      Glow glow = new Glow();   
			    	      glow.setLevel(40);  
			    	      
			    	      text1.setEffect(glow);
			          }
			        });
	
		Background bg = new Background(2);
		ImageView background = bg.getImage();
		root.getChildren().addAll(background,start,Exit,mute,name);
		Scene scene2 = new Scene(root,800,600);
		
		

		
		
		primaryStage.setScene(scene2);
		primaryStage.setTitle("Base Defence");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	
	public static void main (String [] args) {
		launch(args);
	}
	
	public void setUpAddButtonEvent(Button addButton,int k) {
		addButton.setOnAction((EventHandler<ActionEvent>) new AddButtonEventHandler(k));
	}

	public class AddButtonEventHandler implements EventHandler<ActionEvent> {

		private int k;

		public AddButtonEventHandler(int k) {
			this.k =k;
		}

		@Override
		public void handle(ActionEvent arg0) {
			if(k!=0) {
			tutorial t = new tutorial();
	    	t.createPane(1);
	    	t.createScene();
	    	Scene scene3 =t.getScene();
	    	
	    	Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
	    	
	    	window.setScene(scene3);
	    	window.setTitle("Tutorial"+Integer.toString(1));
	    	window.show();}
			if(k==0) {
				Song.isPlaying = !Song.isPlaying;
				if(Song.isPlaying) {
					Song.mediaPlayer.play();
				}
				else {
					Song.mediaPlayer.pause();
				}
			}
			
			
			
		}

	}
}