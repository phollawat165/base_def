package logic;

import Exception.ActiveException;
import Exception.MaxHpException;
import Exception.PressSkillException;
import Object.Player;
import ScoreBoard.Status;

public class Penetrate extends Skills {

	private int skillTimer = 600;
	private boolean isActive;
	private int skillCount;

	public Penetrate() {
		ready = 40;
		maxSkillStack = 4;
		maxGauge = ready * maxSkillStack;
		skillStack = 0;
		isActive = false;
		skillCount = 0;

	}

	@Override
	public void pressSkill() {
		// TODO Auto-generated method stub
		try {
			if(isActive) {
				throw new ActiveException();
			}
			else if(!skillReady()) {
				throw new PressSkillException();
			}
			isActive = true;
			gauge -= ready;
			skillStack--;
			System.out.println("Bullets are now penetrated!");
			Status.statusInt = 10;
		}
		catch(PressSkillException e) {
			System.out.println("Skill isn't fully charge yet!");
			Status.statusInt = 2;
		}
		catch(ActiveException e) {
			System.out.println("bullet is still penetrate");
			}
	}

	public void counting() {
		skillCount++;
		if (skillCount >= skillTimer) {
			isActive = false;
			skillCount = 0;
			Status.statusInt = 1;
		}
	}

	public boolean isActive() {
		return isActive;
	}
}
