package gui;

import gui.SelectCharactor.AddButtonEventHandler;
import javafx.application.Platform;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EndGame implements SceneChanger {
	private AnchorPane EndPane = new AnchorPane();
	private Button PlayAgain = new Button();
	private Button Exit = new Button();
	private Text text1 = new Text("YOU LOSE");
	private Text textYS = new Text("YOUR SCORE");
	private Text textPA = new Text("Play Again");
	private Text textE = new Text("Exit");
	private Text textS = new Text();
	private Scene sceneEnd;
	private StackPane root = new StackPane();
	private MuteButton mute = new MuteButton();
	private int score;
	private int ShipNuimber;
	
	public EndGame(int score,int ShipNuimber) {
		this.ShipNuimber = ShipNuimber;
		Song song = new Song(1);
		this.score = score;
		setUpAddButtonEvent(mute, 0);
		StackPane.setAlignment(mute, Pos.TOP_LEFT);
		  text1.setFill(Color.MEDIUMAQUAMARINE);
	      text1.setFont(new Font("Arial", 30));
	      
	      textYS.setFill(Color.MEDIUMAQUAMARINE);
	      textYS.setFont(new Font("Arial", 30));
	      
	      textPA.setFill(Color.MEDIUMAQUAMARINE);
	      textPA.setFont(new Font("Arial", 30));
	      
	      textE.setFill(Color.MEDIUMAQUAMARINE);
	      textE.setFont(new Font("Arial", 30));
	      
	      textS.setText(Integer.toString(score));
	      textS.setFill(Color.MEDIUMAQUAMARINE);
	      textS.setFont(new Font("Arial", 30));
	      StackPane.setAlignment(textS, Pos.CENTER);
	      
	      Glow glow = new Glow();
	      glow.setLevel(10);  
	      
	      text1.setEffect(glow);
	      text1.setX(320);
	      text1.setY(94);
	      
	      textYS.setEffect(glow);
	      textYS.setX(300);
	      textYS.setY(250);
	      
	      textPA.setEffect(glow);
	      textE.setEffect(glow);
	      textS.setEffect(glow);
	      
	      PlayAgain.setGraphic(textPA);
	      PlayAgain.setStyle("-fx-background-color: transparent; ");
	      
	      Exit.setGraphic(textE);
	      Exit.setStyle("-fx-background-color: transparent; ");
	      
		
        AnchorPane.setLeftAnchor(PlayAgain, 100.0);
        AnchorPane.setBottomAnchor(PlayAgain, 55.0);
        
        AnchorPane.setRightAnchor(Exit, 100.0);
        AnchorPane.setBottomAnchor(Exit, 55.0);
        setUpAddButtonEvent(Exit, -1);
        setUpAddButtonEvent(PlayAgain, 1);
        
        PlayAgain.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  textPA.setFont(new Font("Arial", 40));
		          }
		        });

	   PlayAgain.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  textPA.setFont(new Font("Arial", 30));
		          }
		        });
	  
	   Exit.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  textE.setFont(new Font("Arial", 40));
		        	  
		          }
		        });

	   Exit.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  textE.setFont(new Font("Arial", 30));
		        	  
		          }
		        });
       
        
	}
	@Override
	public AnchorPane getPane() {
		return EndPane;
	}
	@Override
	public void createScene() {
		sceneEnd = new Scene(root,800,600);
	}
	@Override
	public Scene getScene() {
		return sceneEnd;
	}
	public void createPane() {
		EndPane.getChildren().addAll(text1,PlayAgain,Exit,textYS);
		
		Background bg = new Background(3);
		ImageView image = bg.getImage();
		
		image.setFitHeight(600);
		image.setFitWidth(800);
		
		root.getChildren().addAll(image,EndPane,mute,textS);
	}
	@Override
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
			if(k==-1) { Platform.exit();}
			else if(k==0) {
				Song.isPlaying = !Song.isPlaying;
				if(Song.isPlaying) {
					Song.mediaPlayer.play();
				}
				else {
					Song.mediaPlayer.pause();
				}
			}
			else {
				SelectCharactor selectCharactor = new SelectCharactor(ShipNuimber);
				selectCharactor.createPane();
				selectCharactor.createScene();
		    	Scene scene =selectCharactor.getScene();
		    	
		    	Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
		    	
		    	window.setScene(scene);
		    	window.setTitle("SelectCharactor");
		    	window.show();}
		}

	}
}
