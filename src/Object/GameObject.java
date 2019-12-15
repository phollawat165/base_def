package Object;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObject {

	protected Node view;
	private boolean alive = true;
	protected Point2D velocity = new Point2D(0, 0);
	
	
	public GameObject(Node view) {
		this.view = view;
	}
	
	// still have?
	public void update() {
		view.setTranslateX(view.getTranslateX() + velocity.getX());
		view.setTranslateY(view.getTranslateY() + velocity.getY());
	}
	
	public Point2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Point2D velocity) {
		this.velocity = velocity;
	}

	public Node getView() {
		return view;
	}

	public void setView(Node view) {
		this.view = view;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public boolean isDead() {
		return !alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public boolean isColliding(GameObject other) {
		return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
	}
}
