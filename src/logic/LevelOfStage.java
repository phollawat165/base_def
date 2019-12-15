package logic;

public class LevelOfStage {

	// length of game time
	private int time;
	// rate of level stage
	private double spawnRate;
	private int level;
	private double enemySpeed;
	
	
	public LevelOfStage() {
		time = 0;
		level = 1;
		levels(level);
	}
	
	public void incresingTime() {
		time++;
	}
	
	public int getTime() {
		return time;
	}

	public int getLevel() {
		return level;
	}
	
	public double getSpawnRate() {
		return spawnRate;
	}
	
	public double getEnemySpeed() {
		return enemySpeed;
	}

	public void incresingLevel() {
		if(time >= 1500) {
			time = 0;
			level++;
			levels(level);
		}
	}

	public void  levels(int level) {
		switch(level) {
		case 1:
			level = 1;
			spawnRate = 0.01;
			enemySpeed = 0.5;
			break;
		case 2:
			level = 2;
			spawnRate = 0.02;
			enemySpeed = 0.75;
			break;
		case 3:
			level = 3;
			spawnRate = 0.03;
			enemySpeed = 1;
			break;
		case 4:
			level = 4;
			spawnRate = 0.03;
			enemySpeed = 1.25;
			break;
		case 5:
			level = 5;
			spawnRate = 0.03;
			enemySpeed = 1.5;
			break;
		case 6:
			level = 6;
			spawnRate = 0.04;
			enemySpeed = 1.5;
			break;
		case 7:
			level = 7;
			spawnRate = 0.05;
			enemySpeed = 1.5;
			break;
		case 8:
			level = 8;
			spawnRate = 0.06;
			enemySpeed = 1.5;
			break;
		case 9:
			level = 9;
			spawnRate = 0.06;
			enemySpeed = 1.75;
			break;
		
		}
	}
}
