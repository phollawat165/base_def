package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main.AddButtonEventHandler;

public class tutorial implements SceneChanger {
	private AnchorPane tuPane = new AnchorPane();
	private Button next = new Button();
	private Button back = new Button();
	private Button skip = new Button();
	private Text text1 = new Text("TUTORIAL");
	private Text textT = new Text();
	private Text textN = new Text("");
	private Text textB = new Text("");
	private Text textS = new Text("V");
	private Scene sceneTu;
	private StackPane root = new StackPane();
	private int page=1;
	private MuteButton mute = new MuteButton();
	
	public tutorial() {
		setUpAddButtonEvent(mute, 0);
		StackPane.setAlignment(mute, Pos.TOP_LEFT);
		  text1.setFill(Color.MEDIUMAQUAMARINE);
	      text1.setFont(new Font("Arial", 30));
	      
	      textN.setFill(Color.MEDIUMAQUAMARINE);
	      textN.setFont(new Font("Arial", 70));
	      
	      textB.setFill(Color.MEDIUMAQUAMARINE);
	      textB.setFont(new Font("Arial", 70));
	      
	      textS.setFill(Color.MEDIUMAQUAMARINE);
	      textS.setFont(new Font("Arial", 33));
	      
	      Glow glow = new Glow();
	      glow.setLevel(10);  
	      
	      text1.setEffect(glow);
	      text1.setX(330);
	      text1.setY(94);
	      
	      textN.setEffect(glow);
	      textB.setEffect(glow);
	      textS.setEffect(glow);
	      
	      next.setGraphic(textN);
	      next.setPrefSize(200, 400);
	      next.setStyle("-fx-background-color: transparent; ");
	      
	      next.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  textN.setText(">    ");
			          }
			        });

		  next.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  textN.setText("");
			          }
			        });
		  
		  back.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  textB.setText("    <");
			        	  
			          }
			        });

		  back.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  textB.setText("");
			        	  
			          }
			        });
		  skip.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  textS.setText("SKIP\n");
			        	  textS.setFont(new Font("Arial", 35));
			        	  
			          }
			        });

		  skip.addEventHandler(MouseEvent.MOUSE_EXITED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			        	  textS.setText("V");
			        	  textS.setFont(new Font("Arial", 33));
			        	  
			          }
			        });
	      
	      back.setGraphic(textB);
	      back.setPrefSize(200, 400);
	      back.setStyle("-fx-background-color: transparent; ");
	      
	      
	      skip.setGraphic(textS);
	   
	      skip.setStyle("-fx-background-color: transparent; ");
	    
	     
		
		StackPane.setAlignment(skip,Pos.BOTTOM_CENTER);
		
        AnchorPane.setLeftAnchor(back, 0.0);
        AnchorPane.setBottomAnchor(back, 100.0);
        
        AnchorPane.setRightAnchor(next, 0.0);
        AnchorPane.setBottomAnchor(next, 100.0);
        setUpAddButtonEvent(back, -1);
        setUpAddButtonEvent(next, 1);
        setUpAddButtonEvent(skip, 10);
        
	}
	@Override
	public AnchorPane getPane() {
		return tuPane;
	}
	@Override
	public void createScene() {
		sceneTu = new Scene(root,800,600);
	}
	@Override
	public Scene getScene() {
		return sceneTu;
	}
	public void createPane(int p) {
		this.page =p;
		if(page == 1) tuPane.getChildren().addAll(text1,next);
        else if(page == 6) tuPane.getChildren().addAll(text1,back);
        else tuPane.getChildren().addAll(text1,next,back);
		
		String script = setText();
		textT.setText(script);
		textT.setFill(Color.MEDIUMAQUAMARINE);
	    textT.setFont(new Font("Arial", 20));
	    StackPane.setAlignment(textT, Pos.CENTER);
	    
		
		
		
		Background bg = new Background(3);
		ImageView image = bg.getImage();
		
		image.setFitHeight(600);
		image.setFitWidth(800);
		
		root.getChildren().addAll(image,tuPane,mute,skip,textT);
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
			if(k == 1 || k==-1) {
			int newPage = page;
			if(k == 1) {
				newPage = page+1;
			}
			else if(k == -1) {
				newPage = page-1;
			}
			tutorial other = new tutorial();
	    	other.createPane(newPage);
	    	other.createScene();
	    	Scene scene =other.getScene();
	    	
	    	Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
	    	
	    	window.setScene(scene);
	    	window.setTitle("Tutorial"+Integer.toString(newPage));
	    	window.show();}
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
				SelectCharactor selectCharactor = new SelectCharactor(1);
				selectCharactor.createPane();
				selectCharactor.createScene();
		    	Scene scene =selectCharactor.getScene();
		    	
		    	Stage window = (Stage)(((Node) arg0.getSource()).getScene().getWindow());
		    	
		    	window.setScene(scene);
		    	window.setTitle("SelectCharactor");
		    	window.show();}
		}

	}
	public String setText() {
		String des;
		 switch(page) {
			case 1 : des = "<< Use your mouse cursor to control your "
					+"\n\n  ship movement and bullet direction. >>"; 
			break;
			case 2 : des = "<< The ship will do auto-fire for you."
			        +"\n\n  Try to shoot down all enemies. >>"; 
			break;
			case 3 : des = "<< When the enemies hit you will lose "
					+"\n\n  your health point, so try to avoid them. >>"; 
			break;
			case 4 : des = "<< We have 3 types of ship for you to choose,"
					+"\n\n  try the one that suit for you. >>"; 
			break;			
			case 5 : des = "<< When the gauge reach it point, you can use"
					+"\n\n  your skill to have an advantage in the game. >>"; 
			break;
			default : des = "<< The more time you survive,"+
					"\n\n  the more score point you gain. >>";
	}
		 return des;
	
}}
