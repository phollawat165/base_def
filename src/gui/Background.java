package gui;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Background {
	private ImageView image;
	public Background(int number) {
		String url;
		switch(number) {
		case 1 : url = "BGselect.png"; break;
		case 2 : url = "BGmain1.png"; break;
		case 3 : url = "BGtu1.png"; break;
		case 4 : url = "BGchara1.png"; break;
		case 5 : url = "scoreBG.png"; break;
		default : url = "bgGame.png";
		
	}
	
	if(ClassLoader.getSystemResource(url) == null) {
		image = new ImageView(new Image("file:res/"+url));
	}
	else {
	String image_path = ClassLoader.getSystemResource(url).toString();
	    image = new ImageView(new Image(image_path));}
	image.setFitWidth(800);
	image.setFitHeight(600);
//	if(number>4) {
//		image.setFitWidth(1000);
//	}
	}
	
	public ImageView getImage() {
		return image;
	}

}
