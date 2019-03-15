public class Creature {

	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private Room room;
	
	public Creature() {
		name = "";
		description = "";
		hitPoints = 0;
		damage = 0;
		room = null;
	}

	public Creature(String n, String d, int h, int dam) {
		this();
		name = n;
		description = d;
		hitPoints = h;
		damage = dam;
		room = null;		
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return this.description;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitpoints(int h) {
		hitPoints = h;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int dam) {
		damage = dam;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room r) {
		room = r;
	}
	
	public void attack (Creature creature) {
		creature.takeDamage(damage);
		System.out.println(this.name + " attacks " + creature.getName() + " dealing " + damage + " damage");
	}
	
	public void takeDamage(int dam) {
		if(hitPoints - dam > 0) {
			hitPoints = hitPoints - dam;
		}
		else {
		hitPoints = 0;
		}
	}
	
	public boolean isAlive() {
		if (hitPoints > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String s = String.format("name %15s, description %20s, hitPoints %03d, damage %02d"
				,name, description, hitPoints, damage);
		return s;
	}	
}