package logic;

import Object.Player;
import application.GamePlay;

public class Heal extends Skills {

	public Heal() {
		// TODO Auto-generated constructor stub
		ready = 50;
		maxSkillStack = 5;
		maxGauge = ready * maxSkillStack;
		skillStack = 0;
	}

	@Override
	public void pressSkill() {
		// TODO Auto-generated method stub
		if (Player.health < 10 && skillReady()) {
			Player.health++;
			gauge -= ready;
			skillStack--;
			System.out.println("Player's Health is turned to " + Player.health + " !!");
		}else {
			if(Player.health >= 10 ) System.out.println("Player has full health!");
			if(!skillReady()) System.out.println("Skill isn't fully charge yet!");
		}
	}

	@Override
	protected boolean skillReady() {
		// TODO Auto-generated method stub
		if (gauge >= ready)
			return true;
		return false;
	}

	@Override
	public void incresingGauge() {
		// TODO Auto-generated method stub
		if (gauge < maxGauge)
			gauge++;
			System.out.println("Gauge : "+gauge);
		if (((int) (gauge / ready) > skillStack) && (skillStack < maxSkillStack)) {
			skillStack++;
			System.out.println("Skill : Heal : " + skillStack);
		}
	}

}
