package Object;

import application.Field;
import application.GamePlay;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject{

	private static Point2D location;
	// velocity is in GameObject
	private Point2D acceleration;
	private double topspeed;
	
	private static int sizeW = 50;
	private static int sizeH = 30;
	private static double centerW = sizeW/2.5;
	private static double centerH = sizeH/1.5;
	// for rotate method;
	private double r;
	
	// ship
	static Node ship;
	public static int health;
	
	public Player(int k) {
		super(new Rectangle(50, 20, Color.BLUE.deriveColor(1, 1, 1, 0.3)));
		// initialize player
		location = new Point2D(Field.getW()/2, Field.getH()/2);
		velocity = new Point2D(0, 0);
		topspeed = 3.5;
		
		String url = "spaceShips_007.png";
		switch(k) {
		case 1 : url = "spaceShips_007.png"; break;
		case 2 : url = "spaceShips_005.png"; break;
		case 3 : url = "spaceShips_006.png"; break;}
		ImageView image;
		if(ClassLoader.getSystemResource(url) == null) {
			image = new ImageView(new Image("file:res/"+url));
		}
		else {
		String image_path = ClassLoader.getSystemResource(url).toString();
		    image = new ImageView(new Image(image_path));}
		image.setRotate(180);
		image.setFitHeight(50);
		image.setFitWidth(50);
		ship = image;
		//set common ship
		setView(ship);
	}

	// movement method
	public void step(Point2D mouse) {

		Point2D dir = new Point2D(mouse.getX()-location.getX()-centerW, mouse.getY()-location.getY()-centerH);
		dir = dir.normalize().multiply(0.5);
        acceleration = dir;
        velocity = velocity.add(acceleration);
        velocity = limit(topspeed,velocity);
        location = location.add(velocity);

		r = Math.toDegrees(Math.atan(dir.getY() / dir.getX()));
		if(mouse.getX()-location.getX()-centerW < 0) r=180+r;
		

		ship.setRotate(r);

	}
	
	private Point2D limit(double topspeed, Point2D p) {
        if (p.magnitude() > topspeed) {
            p = p.normalize().multiply(topspeed);
        }
		return p;
    }

	public void update() {
		view.setTranslateX(location.getX());
		view.setTranslateY(location.getY());

		// player movement
		step(GamePlay.ms);

		// check border
		checkBoundaries();

	}
	
	public static void checkBoundaries() {

		if (location.getX() >= Field.getW()) {
			location = new Point2D(0, location.getY());
		} else if (location.getX() <= 0) {
			location = new Point2D(Field.getW(), location.getY());
		}

		if (location.getY() >= Field.getH()) {
			location = new Point2D(location.getX(), 0);
		} else if (location.getY() <= 0) {
			location = new Point2D(location.getX(), Field.getH());
		}
	}

	public double getCenterW() {
		return centerW;
	}

	public double getCenterH() {
		return centerH;
	}

	public Point2D getAcceleration() {
		return acceleration;
	}
	
	public Point2D getLocation() {
		return location;
	}

	public void setLocation(Point2D location) {
		this.location = location;
	}

	public double getTopspeed() {
		return topspeed;
	}

	public void setTopspeed(double topspeed) {
		this.topspeed = topspeed;
	}

}
