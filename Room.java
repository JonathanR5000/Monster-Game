public class Room {

	private int roomIndex;
	private String description;
	private Monster monster;
	
	public Room(int rIndex, String d, Monster m) {
		roomIndex = rIndex;
		description = d;
		monster = m;
		
	}
	
	public Monster getMonster() {
		return this.monster;
	}
	public String getDescription() {
		return description;
	}
		
	public boolean isComplete() {
			if(monster.isAlive() == false) {
				return true;
			}
			else {
				return false;
			}
		}
		
	public void enter(Player player) {
		if(monster.isAlive() == true){
		System.out.println(player.getName() + ": This room is " + this.description + " and has a " + this.monster.getName());
		}
	}	
	
	@Override
	public String toString() {
		String s = String.format("Room index %2d, description %20s, monster name %20s"
				, this.roomIndex, this.description, this.monster.getName());
		return s;
	}
}