package Object;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet extends GameObject{
	
	public Bullet() {
		super(new Circle(5, 5, 5, Color.ORANGERED));
		
		// TODO Auto-generated constructor stub
	}
}
