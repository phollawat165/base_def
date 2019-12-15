package logic;

public abstract class Skills {

	public static int gauge;
	public static int maxGauge;
	protected int ready;
	protected int chargeTime;
	protected int skillStack;
	protected int maxSkillStack;
	
	
	public Skills() {
		chargeTime = 0;
		gauge = 0;
	}
	
	public void setting() {
		chargeTime++;
		if(chargeTime>=300) {
			chargeTime = 0;
			incresingGauge();
		}
	}
	
	public abstract void incresingGauge();
	
	public abstract void pressSkill();
	
	protected abstract boolean skillReady();
	
}
