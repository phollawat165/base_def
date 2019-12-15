package logic;

import Exception.MaxHpException;
import Exception.PressSkillException;
import Object.Player;
import ScoreBoard.Status;
import application.GamePlay;

public class Heal extends Skills {

	public Heal() {
		// TODO Auto-generated constructor stub
		ready = 40;
		maxSkillStack = 5;
		maxGauge = ready * maxSkillStack;
		skillStack = 0;
	}

	@Override
	public void pressSkill() {
		// TODO Auto-generated method stub
		try {
			if(!skillReady()) {
				throw new PressSkillException();
			}
			else if(Player.health == 10) {
				throw new MaxHpException();
			}
			Player.health++;
			gauge -= ready;
			skillStack--;
			Status.statusInt = 5;
			System.out.println("Player's Health is turned to " + Player.health + " !!");
		}
		catch(MaxHpException e) {
			System.out.println("Player has full health!");
			Status.statusInt = 3;
			}
		catch(PressSkillException e) {
			System.out.println("Skill isn't fully charge yet!");
			Status.statusInt = 2;
		}
		
	}
}