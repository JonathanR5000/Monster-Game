import java.util.Scanner;

public class Battle {
	
	Player player;
	Monster monster;
	Scanner in = new Scanner(System.in);

	public Battle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
	}
	
	public void run() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Battle Begins: " + player.getName() + " vs. " + monster.getName());
		
		while(player.isAlive()) {

			System.out.println("--------------------------------------------------------------");

			System.out.println("Player's turn: attack (a) or heal (h)?");

			String a = in.next();

			if(a.equals("a") || a.equals("A")) {
				System.out.println("--------------------------------------------------------------");
				System.out.println("Players turn: ");
				player.attack(monster);

				if(monster.isAlive()) {
					System.out.print("Monster: " + monster.getHitPoints() + " HP");
					System.out.println(" | Player: " + player.getHitPoints() + " HP");
					System.out.println("--------------------------------------------------------------");
					System.out.println("Monster's turn: ");

					if(monster.canEnrage()) {
						monster.enrage();
						monster.attack(player);
						System.out.print("Monster: " + monster.getHitPoints() + " HP");
						System.out.println(" | Player: " + player.getHitPoints() + " HP");
					}
					else {
						monster.attack(player);
						System.out.print("Monster: " + monster.getHitPoints() + " HP");
						System.out.println(" | Player: " + player.getHitPoints() + " HP");
					}
				}
				else 
				{break;}
			}
			else if(a.equals("h") || a.equals("H")) {
				System.out.println("--------------------------------------------------------------");
				System.out.println("Player's turn: ");
				player.heal();
				System.out.print("Monster: " + monster.getHitPoints() + " HP");
				System.out.println(" | Player: " + player.getHitPoints() + " HP");

				if(monster.isAlive()) {

					System.out.println("--------------------------------------------------------------");			
					System.out.println("Monster's turn: " );

					if(monster.canEnrage()) {

						monster.enrage();
						monster.attack(player);
						System.out.print("Monster: " + monster.getHitPoints() + " HP");
						System.out.println(" | Player: " + player.getHitPoints() + " HP");
					}
					else {
						monster.attack(player);
						System.out.print("Monster: " + monster.getHitPoints() + " HP");
						System.out.println(" | Player: " + player.getHitPoints() + " HP");
					}
				}
				else {
					break;
				}	
			}
			else {
				System.err.println("Wrong charatcer, please try again!");
			}
		}
	}
}