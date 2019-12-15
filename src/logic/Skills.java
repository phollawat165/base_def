
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
	
	public void incresingGauge() {
		if (gauge < maxGauge)
			gauge++;
			System.out.println("Gauge : "+gauge);
		if (((int) (gauge / ready) > skillStack) && (skillStack < maxSkillStack)) {
			skillStack++;
			System.out.println("Skill : Heal : " + skillStack);
		}    
	}
	
	public abstract void pressSkill();
	
	protected boolean skillReady() {
		if (gauge >= ready)
			return true;
		return false;
	}
	
}