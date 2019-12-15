package Object;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Enemy extends GameObject{
	
	private double spawnX;
	private double spawnY;
	private Point2D location;

	public Enemy() {
		super(new Circle(10, Color.RED));
		// TODO Auto-generated constructor stub
	}

	public double getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(double spawnX) {
		this.spawnX = spawnX;
	}

	public double getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(double spawnY) {
		this.spawnY = spawnY;
	}

	public Point2D getLocation() {
		return location;
	}

	public void setLocation() {
		this.location = new Point2D(this.getView().getTranslateX(), this.getView().getTranslateY());
	}

}
