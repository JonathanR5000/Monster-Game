public class Monster extends Creature{

	private boolean isEnraged;
	private int enrageThreshold;

	public Monster() {
		super();
		isEnraged = false;
		enrageThreshold = 0;
	}
	
	public Monster(String name, String description, int hitPoints, int damage, int enRage) {
		super(name, description, hitPoints, damage);
		enrageThreshold = enRage;
	}
	
	public void enrage() {
		if(this.isEnraged == false) {
			this.isEnraged = !this.isEnraged;
		System.out.print(this.getName() + " HAS BEEN ENRAGED ");
		this.setDamage(this.getDamage() * 2);
			}
	}
	
	public boolean canEnrage() {
		if(this.getHitPoints() < this.enrageThreshold) {
			return true;
		}
		else {
			return false;
		}
	}
}