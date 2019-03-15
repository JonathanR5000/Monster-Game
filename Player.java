public class Player extends Creature{

	private int healAmount;
	
	public Player(String name, String description, int hitPoints, int damage, int heal) {
		super(name, description, hitPoints, damage);
		healAmount = heal;
	}
	
	public void heal() {
		System.out.println(this.getName() + " is healed by " + this.healAmount);
		this.setHitpoints(this.getHitPoints() + healAmount);
	}	
}