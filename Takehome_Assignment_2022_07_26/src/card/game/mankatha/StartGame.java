package card.game.mankatha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {

	//private static final int NO_OF_PLAYERS = 3;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Mankatha: The Card Game!");
		char choice;
		
		do {
		System.out.print("Please enter the number of players: ");
		int noOfPlayers = sc.nextInt();
		

		List<Player> playerList = new ArrayList<Player>();
		
		for(int n = 0; n < noOfPlayers; n++) {
			System.out.print("Enter Player " + (n+1) + " name: ");
			String playerName = sc.next();
			Player p = new Player(playerName);
			playerList.add(p);
			System.out.println(p);
		}
		
		
		PlayGame pg = new PlayGame(playerList);

		pg.play();
		System.out.println("Want to play another game? [y/n]: ");
		choice = sc.next().charAt(0);
		}while(choice == 'y');

	}

}
