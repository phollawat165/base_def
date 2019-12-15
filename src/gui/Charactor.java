package gui;

import gui.SelectCharactor.AddButtonEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import application.*;


public class Charactor implements SceneChanger {
	private AnchorPane CharactorPane = new AnchorPane();
	private Button start = new Button();
	private Button back = new Button();
	private Text textS = new Text("GAME START");
	private Text textB = new Text(">");
	private Scene sceneCharactor;
	private StackPane root = new StackPane();
	private VBox bar;
	private VBox name;
	private MuteButton mute = new MuteButton();
	
	private int number;
	
	public Charactor(int number) {
		setUpAddButtonEvent(mute, 0);
		StackPane.setAlignment(mute, Pos.TOP_LEFT);
		this.number = number;
		
		this.bar = new BarChartPane(number).getPane();
		this.name = new BarChartName().getPane();
		
	    textB.setFill(Color.CYAN);
	    textB.setFont(new Font("Arial", 30));
	      
	    textS.setFill(Color.CYAN);
	    textS.setFont(new Font("Arial", 30));
	    
	    start.setStyle("-fx-background-color: transparent; ");
	    back.setStyle("-fx-background-color: transparent; ");
	   
	    start.setGraphic(textS);
	    
	    back.setGraphic(textB);
	    
	    back.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  textB.setText("BACK >");
		          }
		        });

	    back.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  textB.setText(">");
		          }
		        });
	    
		
        AnchorPane.setLeftAnchor(start, 10.0);
        AnchorPane.setBottomAnchor(start, 10.0);
        
        AnchorPane.setRightAnchor(back, 10.0);
        AnchorPane.setBottomAnchor(back, 10.0);
        
        AnchorPane.setLeftAnchor(bar, 580.0);
        AnchorPane.setTopAnchor(bar, 110.0);
        
        AnchorPane.setLeftAnchor(name, 425.0);
        AnchorPane.setTopAnchor(name, 132.0);

        
        
        setUpAddButtonEvent(start, 1);
        setUpAddButtonEvent(back, -1);
        
	}
	@Override
	public AnchorPane getPane() {
		return CharactorPane;
	}
	@Override
	public void createScene() {
		sceneCharactor = new Scene(root,800,600);
	}
	@Override
	public Scene getScene() {
		return sceneCharactor;
	}
	public void createPane() {
		
		CharactorPane.getChildren().addAll(bar,name,start,back);
		Background bg = new Background(4);
		ImageView image = bg.getImage();
		
		image.setFitHeight(600);
		image.setFitWidth(800);
		
		root.getChildren().addAll(image,CharactorPane,mute);
	}
	
	@Override
	public void setUpAddButtonEvent(Button addButton,int k) {
		addButton.setOnAction((EventHandler<ActionEvent>) new AddButtonEventHandler(k));
	}

	private class AddButtonEventHandler implements EventHandler<ActionEvent> {
		private int k;

		public AddButtonEventHandler(int k) {
			this.k =k;
		}
		

		@Override
		public void handle(ActionEvent arg0) {
			if(k == -1) {
			SelectCharactor selectCharactor = new SelectCharactor(number);
			selectCharactor.createPane();
			selectCharactor.createScene();
	    	Scene scene =selectCharactor.getScene();
	    	
	    	Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
	    	
	    	window.setScene(scene);
	    	window.setTitle("SelectCharactor");
	    	window.show();}
			else if(k == 1) {
			GamePlay game = new GamePlay(number);
			Song.mediaPlayer.stop();
			Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
			try {
				game.start(window);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else if(k==0) {
				Song.isPlaying = !Song.isPlaying;
				if(Song.isPlaying) {
					Song.mediaPlayer.play();
				}
				else {
					Song.mediaPlayer.pause();
				}
			}
			
		}
		
	
}}


