package logic;

public class Character {

	private int selection;
	private int health;
	private int firerate; // less mean fast
	private double bulletSpeed;
	private double topspeed;
	
	public Character(int selection) {
		this.selection = selection;
		setting();
	}
	
	private void setting() {
		switch(selection) {
		case 1:
			health = 5;
			firerate = 15;
			bulletSpeed = 6;
			topspeed = 3.5;
			break;
		case 2:
			health = 3;
			firerate = 10;
			bulletSpeed = 10;
			topspeed = 4;
			break;
		case 3:
			health = 10;
			firerate = 20;
			bulletSpeed = 4;
			topspeed = 3;
			break;
		}
	}

	public int getHealth() {
		return health;
	}

	public int getFirerate() {
		return firerate;
	}

	public double getBulletSpeed() {
		return bulletSpeed;
	}

	public double getTopspeed() {
		return topspeed;
	}
	
	
}
