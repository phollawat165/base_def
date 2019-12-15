package logic;

import java.awt.event.ActionEvent;

import Object.Player;
import ScoreBoard.GameBar;
import ScoreBoard.Score;
import application.Field;
import application.GamePlay;
import javafx.application.Platform;
import javafx.event.EventHandler;
import main.Main;

public class Timer{
	
	
	public static final int SLEEP_TIME = 1000;
	private Score score;
	private GameBar gamebar;
	
	public static int point = 0;
	private boolean isCounting;
	public static Thread thread;
	// implement your code here
	
	
	public Timer() {
		this.score = new Score();
		this.gamebar = new GameBar();
		this.isCounting = false;
		
		this.threadInitialize();
		this.updateGUI();
		this.thread = new Thread();
		score.getDisplayPart().update(getTimeString());
		
	
		// implement your code here
		
	}
	
	
	private void threadInitialize() {
		this.thread = new Thread(()-> {
			while(isCounting) {
				try {
					updateTime();
					updateGUI();
					this.getThread().sleep(SLEEP_TIME);
					
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});}
	
	
	
	private void updateGUI() {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				if(Field.isStart) {
				score.getDisplayPart().update(getTimeString());
//				gamebar.getHpBar().update(getHPString());
				gamebar.getGaugeBar().update(getGaugeString());
				}
			
				// TODO Auto-generated method stub
			}
		});
		// implement your Pcode here
		
	}
	
	private void updateTime() {
		point++;
			
		}
		// implement your code here
		
	
	
	
	private String getTimeString() {
		return Integer.toString(point);
		// implement your code here
		
	}
//	private String getHPString() {
//		return Integer.toString(Player.health)+"/"+
//	Integer.toString(Character.health);
//		// implement your code here
//		
//	}
	private String getGaugeString() {
		return Integer.toString(Skills.gauge)+"/"+
				Integer.toString(Skills.maxGauge);
		// implement your code here
		
	}
	
	
	
		// implement your code here
	
	public void startStopHandle() {
		if(!isCounting) {
			this.threadInitialize();
			thread.start();
		}
		isCounting = !isCounting;
		// implement your code here
		
	}
	
	
	
	public Score getScore() {
		return score;
	}
	public Thread getThread() {
		return thread;
	}
	public GameBar getGameBar() {
		return gamebar;
	}
	
	
	
	//Generate Getters
	
		
}
