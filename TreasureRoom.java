public class TreasureRoom extends Room{

	private String treasure;

	public TreasureRoom(String description, Monster monster, String treas) {
		super(2, description, monster);
		treasure = treas;
	}
	
	@Override
	public void enter(Player player) {
		if(this.getMonster().isAlive() == true) {
			System.out.println("This room is " + this.getDescription() +  " and has " + this.getMonster().getName());
		}
		if(super.isComplete() == true) {
			treasure = "YOU EXPLORED THE ROOM AND FOUND THE HIDDEN TREASURE!";
			System.out.println(treasure);
		}
	}
}