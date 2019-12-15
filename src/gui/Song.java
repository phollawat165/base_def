package gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.Main;

public class Song {
	public static boolean isPlaying = true;
	private Media bgMedia;
	public static MediaPlayer mediaPlayer;
	private int music;
	public Song(int music) {
		String url = "DestinyFierceBattle.mp3";
		switch(music) {
		case 1 : url = "finalHour.mp3"; break;
		default : url = "DestinyFierceBattleCut.mp3";
		
	}
		if(ClassLoader.getSystemResource(url) == null) {
			mediaPlayer = new MediaPlayer(new Media("file:res/"+url));
		}
		else {
		String song_path = ClassLoader.getSystemResource(url).toString();
		mediaPlayer = new MediaPlayer(new Media(song_path));}
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setVolume(0.4);
		if(music == 1) {
		mediaPlayer.setVolume(0.7);}
		mediaPlayer.play();
	}
	
}
