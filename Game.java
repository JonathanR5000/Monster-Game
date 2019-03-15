import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

	private Player player;
	private Room[] dungeon;
	
	
	public Game() {

		Scanner p = null;
		
		String pName = "";
		String pDescription = "";
		int pHealth = 0;
		int pAttack = 0;
		int pHeal = 0;
		
		try {
			p = new Scanner(new File("PlayerInfo.txt"));
			
			pName = p.nextLine();
			pDescription = p.nextLine();
			pHealth = p.nextInt();
			pAttack = p.nextInt();
			pHeal = p.nextInt();
		}
		catch(FileNotFoundException f) {
			System.out.println("File Not Found");
		}
		finally {
			if(p != null) {
				p.close();
			}
		}
		player = new Player(pName, pDescription, pHealth, pAttack, pHeal);
		
		dungeon = new Room[3];

		Monster monster1 = new Monster("Orc", "covered with green blood", 20, 5, 0);
		Room room1 = new Room(0, "A room with an unbearable smell", monster1);
		
		Monster monster2 = new Monster("Skeleton", "funny how it moves", 40, 10, 10);
		Room room2 = new Room(1, "Dark and cold", monster2);
		
		Monster monster3 = new Monster("Fire dragon", "spout fire with each breath", 100, 20, 40);
		Room room3 = new TreasureRoom("A giant hall with something shiny on the other end", monster3, "a large pile of gold");

		dungeon[0] = room1;
		dungeon[1] = room2;
		dungeon[2] = room3;
	}
	
	public void Play() {
		System.out.println("Welcome to the MONSTER GAME");
		System.out.println(player.toString());
		for(int i = 0; i < dungeon.length; i++) {
			System.out.println(this.player.getName() + " enters room " + i);
			dungeon[i].enter(player);
			Battle battle = new Battle(player, dungeon[i].getMonster());
			System.out.println(dungeon[i].getMonster().toString());
			battle.run();
			if(i == dungeon.length - 1) {
				dungeon[dungeon.length - 1].enter(player);
			}
		if(player.isAlive() == false) {
			System.out.println(player.getName() + " is dead");
			System.out.println("GAME OVER");
			break;
		}
		System.out.println("**************************************************************");
		}
	}
	
	public static void main(String[]args) {	
		Game game = new Game();
		game.Play();
	}
}