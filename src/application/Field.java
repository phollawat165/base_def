package application;

import java.util.ArrayList;
import java.util.List;

import Object.Bullet;
import Object.Enemy;
import Object.GameObject;
import Object.Player;
import ScoreBoard.Status;
import gui.EndGame;
import gui.SelectCharactor;
import gui.Song;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.LevelOfStage;
import logic.Penetrate;
import logic.Skills;
import logic.Timer;
import logic.Character;
import logic.Heal;
import logic.Immortal;

public class Field extends Pane {
	
	private static Pane root;
	private static int w = 750;
	private static int h = 600;
	
	public static boolean isStart = false;
	
	private static List<Bullet> bullets = new ArrayList<>();
	private List<Enemy> enemies = new ArrayList<>();
	
	private AnimationTimer timer;
	private int currentHP;
	private int ShipNuimber;

	private int deploy = 0;
	private int STATUS_INT=0;
	private int countDown =0;

	// test character
	public logic.Character character;
	public Skills skill;
	public static Player player;
	
	private LevelOfStage levels = new LevelOfStage();
	
	public Parent createContent(int k) {
		ShipNuimber = k;
		isStart = true;
		root = new Pane();
		root.setPrefSize(w, h);

		// test character
		character = new Character(ShipNuimber);
		initializeSkill(ShipNuimber);
		
		player = new Player(ShipNuimber);
		
		Player.health = character.getHealth();
		player.setTopspeed(character.getTopspeed());
		
		currentHP = character.getHealth();
		
		addGameObject(player, player.getLocation().getX(), player.getLocation().getY());

		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				onUpdate();

//				System.out.println(levels.getLevel());
			}
		};
		timer.start();
		GamePlay.HP.getHpBar().update(getHPString());
		GamePlay.GS.getStatus().update(getStatusInt());

		return root;
	}

	// ok'till
	private void onUpdate() {
		// increase level time and spawn rate
		levels.incresingTime();
		levels.incresingLevel();
		// game logic
		// kill enemy
		for (Bullet bullet : bullets) {
			for (Enemy enemy : enemies) {
				if (bullet.isColliding(enemy)) {
					if(!((skill instanceof Penetrate) && (((Penetrate) skill).isActive()))) {
						bullet.setAlive(false);
						root.getChildren().remove(bullet.getView());
					}   
					enemy.setAlive(false);
					root.getChildren().remove(enemy.getView());
					skill.incresingGauge();
				}
			}
		}
		bullets.removeIf(GameObject::isDead);
		enemies.removeIf(GameObject::isDead);
		// update enemies and bullets movement
		bullets.forEach(GameObject::update);
		enemies.forEach(GameObject::update);

		// player died
		for (Enemy enemy : enemies) {
			if (enemy.isColliding(player)) {
				enemy.setAlive(false);
				if(!((skill instanceof Immortal) && (((Immortal) skill).isActive()))) {
					Player.health--;
				}
				if (Player.health <= 0) {
					player.setAlive(false);
					root.getChildren().remove(player.getView());
				}
				System.out.println("Player's Health is "+Player.health);
				root.getChildren().remove(enemy.getView());
			}
		}
		// update player movement
		player.update();
		// add enemy spawn here
		enemyspawn();
		enemies.forEach((enemy) -> setEnemyRun(enemy));
		// fire bullet
		bulletFireRate();
		// set skill counter
		skill.setting();
		// set Penetrate counter
		if((skill instanceof Penetrate) && (((Penetrate) skill).isActive())) {
			((Penetrate) skill).counting();
		}
		// set Immortal counter
		if((skill instanceof Immortal) && (((Immortal) skill).isActive())) {
			((Immortal) skill).counting();
		}
		// end process wait to fix ending screen (create & implement ending screen
		// method)
		if(currentHP != Player.health) {
			currentHP = Player.health;
			GamePlay.HP.getHpBar().update(getHPString());
		}
		if(countDown == 300) {
			countDown = 0;
			if(Status.statusInt>1 && Status.statusInt<6 )
			Status.statusInt = 1;
			GamePlay.GS.getStatus().update(getStatusInt());
		}
		if(Status.statusInt>1 && Status.statusInt<6 ) {
			countDown++;
		}
		else {
			countDown=0;
		}
		if(STATUS_INT != Status.statusInt) {
			STATUS_INT = Status.statusInt;
			GamePlay.GS.getStatus().update(getStatusInt());
		}
		
		if (player.isDead()) {
			timer.stop();
			GamePlay.score.startStopHandle();
			Song.mediaPlayer.stop();
			EndGame endPane = new EndGame(Timer.point,ShipNuimber);
			endPane.createPane();
			endPane.createScene();
	    	Scene scene =endPane.getScene();

	    	Stage window = (Stage) GamePlay.scene.getWindow();
	    	window.setScene(scene);
	    	window.setTitle("YOU LOSE");
	    	window.show();
		}

	}

	private static void addGameObject(GameObject object, double x, double y) {
		object.getView().setTranslateX(x);
		object.getView().setTranslateY(y);
		root.getChildren().add(object.getView());
	}

	public static void addBullet(Bullet bullet, double x, double y) {
		bullets.add(bullet);
		addGameObject(bullet, x, y);
	}

	private void addEnemy(Enemy enemy, double x, double y) {
		enemies.add(enemy);
		addGameObject(enemy, x, y);
	}

	private void enemyspawn() {
		// enemy's spawn places and frequency
		if (Math.random() < levels.getSpawnRate()) {

			double i = Math.random();
			double x;
			double y;

			if (i < 0.25) {
				x = Math.random() * w;
				y = 0;
				Enemy enemy = new Enemy();
				enemy.setSpawnX(x);
				enemy.setSpawnY(y);
				addEnemy(enemy, x, y);
			} else if (0.25 < i && i < 0.5) {
				x = Math.random() * w;
				y = h;
				Enemy enemy = new Enemy();
				enemy.setSpawnX(x);
				enemy.setSpawnY(y);
				addEnemy(enemy, x, y);
			} else if (0.5 < i && i < 0.75) {
				x = 0;
				y = Math.random() * h;
				Enemy enemy = new Enemy();
				enemy.setSpawnX(x);
				enemy.setSpawnY(y);
				addEnemy(enemy, x, y);
			} else {
				x = w;
				y = Math.random() * h;
				Enemy enemy = new Enemy();
				enemy.setSpawnX(x);
				enemy.setSpawnY(y);
				addEnemy(enemy, x, y);
			}
		}
	}

	private void setEnemyRun(Enemy enemy) {
		enemy.setLocation();
		enemy.setVelocity((new Point2D(player.getLocation().getX() + player.getCenterW() - enemy.getLocation().getX(),
				player.getLocation().getY() + player.getCenterH() - enemy.getLocation().getY())).normalize()
						.multiply(levels.getEnemySpeed()));
	}

	private void bulletFireRate() {
		// bullet's spawn rate & spawn bullet
		deploy++;
		if (deploy == character.getFirerate() && player.isAlive()) { // set bullet fire rate here
			Bullet bullet = new Bullet();
			bullet.setVelocity(GamePlay.ms
					.subtract(new Point2D(player.getLocation().getX() + player.getCenterW(),
							player.getLocation().getY() + player.getCenterH()))
					.normalize().multiply(player.getVelocity().magnitude() + character.getBulletSpeed()));
			addBullet(bullet, player.getView().getTranslateX() + player.getCenterW(),
					player.getView().getTranslateY() + player.getCenterH());
			deploy = 0;
		}
	}
	
	private void initializeSkill(int k) {
		switch (k) {
		case 1:
			skill = new Immortal();
			break;
		case 2:
			skill = new Penetrate();
			break;
		case 3:
			skill = new Heal();
			break;
		}
	}

	public static int getW() {
		return w;
	}

	public static int getH() {
		return h;
	}
	private String getHPString() {
		return Integer.toString(Player.health)+"/"+
	Integer.toString(character.getHealth());
		// implement your code here
		
	}
	private int getStatusInt() {
		return Status.statusInt;
		// implement your code here
		
	}
}

