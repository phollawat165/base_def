package gui;

import gui.tutorial.AddButtonEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SelectCharactor implements SceneChanger {
	private int charactor;
	private AnchorPane CharactorPane = new AnchorPane();
	private Button next = new Button();
	private Button back = new Button();
	private ItemButton CHbutton;
	private Text text1 = new Text("PLEASE SELECT YOUR CHARACTOR");
	private Scene sceneCharactor;
	private StackPane root = new StackPane();
	private MuteButton mute = new MuteButton();
	
	public  SelectCharactor(int charactor) {
		setUpAddButtonEvent(mute, -10);
		StackPane.setAlignment(mute, Pos.TOP_LEFT);
		text1.setFill(Color.MEDIUMAQUAMARINE);
	    text1.setFont(new Font("Arial", 30));
	    
	    
	      text1.setX(137);
	      text1.setY(50);
	      
		this.charactor = charactor;
		this.CHbutton = new ItemButton(Integer.toString(charactor));
		next.setStyle("-fx-background-color: transparent; ");
		back.setStyle("-fx-background-color: transparent; ");
		AnchorPane.setBottomAnchor(CHbutton, 230.0);
		AnchorPane.setLeftAnchor(CHbutton, 321.0);
		
        AnchorPane.setLeftAnchor(back, 230.0);
        AnchorPane.setBottomAnchor(back, 283.0);
        
        AnchorPane.setRightAnchor(next, 230.0);
        AnchorPane.setBottomAnchor(next, 283.0);
        
       
        
        setUpAddButtonEvent(next,-1);
        setUpAddButtonEvent(back,-2);
        setUpAddButtonEvent(CHbutton, this.charactor);
        
        
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
		
		CharactorPane.getChildren().addAll(text1,CHbutton,next,back);
		Background bg = new Background(1);
		ImageView image = bg.getImage();
		
		image.setFitHeight(600);
		image.setFitWidth(800);
		
		root.getChildren().addAll(image,CharactorPane,mute);
	}
	@Override
	public void setUpAddButtonEvent(Button addButton,int k) {
		addButton.setOnAction((EventHandler<ActionEvent>) new AddButtonEventHandler(k));
	}
	public void setCharactor(int charactor) {
		this.charactor = charactor;
		this.CHbutton = new ItemButton(Integer.toString(this.charactor));
	}

	public class AddButtonEventHandler implements EventHandler<ActionEvent> {
		private int k;

		public AddButtonEventHandler(int k) {
			this.k =k;
		}
		

		@Override
		public void handle(ActionEvent arg0) {
			if(k > -1) {
			Charactor other = new Charactor(k);
	    	other.createPane();
	    	other.createScene();
	    	Scene scene =other.getScene();
	    	
	    	Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
	    	
	    	window.setScene(scene);
	    	window.setTitle("Charactor"+Integer.toString(k));
	    	window.show();}
			else if(k==-10) {
				Song.isPlaying = !Song.isPlaying;
				if(Song.isPlaying) {
					Song.mediaPlayer.play();
				}
				else {
					Song.mediaPlayer.pause();
				}
			}
			else {
				int now;
				if(k == -1) {
				now = (charactor+1)%3;
				if(now == 0)now=3;
			}
			else {
				now = (charactor+2)%3;
				if(now == 0)now=3;
				
			}
				SelectCharactor other = new SelectCharactor(now);
				other.createPane();
				other.createScene();
		    	Scene scene =other.getScene();
		    	Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
		    	window.setScene(scene);
		    	window.setTitle("SelectCharactor");
		    	window.show();
				}
			
	    	}
		

	}
}
