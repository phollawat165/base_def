package application;

import java.net.Socket;

import Object.Bullet;
import Object.Player;
import ScoreBoard.GameBar;
import ScoreBoard.HPbar;
import gui.Background;
import gui.BarChartPane;
import gui.Song;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Timer;


public class GamePlay extends Application{
	
	private Field field = new Field();
	public static Timer score;
	// change back to private?
	public static Point2D ms = new Point2D(0, 0);
	public static int number;
	public static Scene scene;
	public static HpRealTime HP;
	
	public GamePlay(int k) {
		number = k;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		score = new Timer();
		HBox BG = new HBox();
		Song song = new Song(0);
		HP = new HpRealTime();
		
		StackPane root = new StackPane();
		StackPane root2 = new StackPane();
		score = new Timer();
		VBox scorepane = new VBox();
		scorepane.getChildren().addAll(score.getScore(),HP,score.getGameBar());
        scorepane.setSpacing(20);
        scorepane.setPadding(new Insets(20));
		Background bg = new Background(6);
		Background bgScore = new Background(5);
		ImageView image = bg.getImage();
		ImageView imageScore = bgScore.getImage();
		imageScore.setFitHeight(600);
		imageScore.setFitWidth(200);
		
		StackPane.setAlignment(score.getScore(), Pos.CENTER);
;
//		BarChartPane bar = new BarChartPane(number);
//		VBox BAR = bar.getPane();
		
		
		
		root.getChildren().add(image);
		root.getChildren().add(field.createContent(number));
		
		root2.getChildren().addAll(imageScore,scorepane);
		BG.getChildren().addAll(root,root2);
	
		scene = new Scene(BG);
		score.startStopHandle();
				
		primaryStage.setScene(scene);
		primaryStage.setTitle("Base Defence");
		
		// capture mouse position
		scene.addEventFilter(MouseEvent.ANY, e -> {
            ms = new Point2D(e.getX(), e.getY());
        });
		
		// try
//		primaryStage.getScene().setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.LEFT) {
//                Field.player.rotateLeft();
//            } else if (e.getCode() == KeyCode.RIGHT) {
//                Field.player.rotateRight();
//            } else if (e.getCode() == KeyCode.SPACE) {
//                Bullet bullet = new Bullet();
//                bullet.setVelocity(Field.player.getVelocity().normalize().multiply(5));
//                Field.addBullet(bullet, Field.player.getView().getTranslateX() + 25, Field.player.getView().getTranslateY() + 25);
//            }
//        });
		// 'til here
		
		primaryStage.show();
	}
	class HpRealTime extends VBox{
		private Text labelHP = new Text("HP");
		private HPbar hpbar;
		public HpRealTime() {
			this.setAlignment(Pos.CENTER);
			this.setSpacing(10);
			this.setPadding(new Insets(10));
			this.labelHP.setFill(Color.MEDIUMAQUAMARINE);
		    this.labelHP.setFont(new Font("Arial", 30));
			Glow glow = new Glow();
		    glow.setLevel(10);  
	        this.labelHP.setEffect(glow);
	        this.hpbar = new HPbar();
	        
	        this.getChildren().addAll(labelHP,hpbar);
		}
		public HPbar getHpBar() {
			return hpbar;
		}
		
	}


	
	
}
