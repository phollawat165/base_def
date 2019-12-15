package gui;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CharactorText {
	private Text text;
	public CharactorText(int number) {
		String script;
		switch(number) {
		case 1 : script = "This is the normal ship which has balance stat.\n"
				+"It has skill to shoot bullets that can penetrate everything\n"+
				"when it has enough energy.";
			break;
		case 2 : script = "This is the fast ship which has the fastest speed\n"
				+"but exchange for it weak body.\n"
				+"It has skill to create an energy shield that will defend any kind\n"+
				"of attack when it has enough energy.";
		   break;
		default : script = "This is the tank ship which has entire ship covers\n"
				+"by the armor ,by the way ,it is the slowet ship.\n"
				+"It has skill to fixs itself when it has enough energy.";
		this.text = new Text(script);
		text.setFill(Color.MEDIUMAQUAMARINE);
		text.setFont(new Font("Arial", 20));
	   
   }
	}
	public Text getText() {
		return text;
	}

}
