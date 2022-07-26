package card.game.mankatha;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayGame {
	
	private List<Player> playerList;
	private int coinPot;
	private Deck d;
	
	public PlayGame() {
		// default constructor
	}
	
	public PlayGame(List<Player> playerList) {
		this.playerList = playerList;
		this.coinPot = 0;
		this.d = new Deck();
		
	}
	
	public int findWinner(Card dealtCard, int dealNumber) {
		System.out.println(playerList);
		System.out.println(dealtCard);
		for(Player p: playerList) {
			if(!p.isHost()) {
				if(p.getChosenCard().equals(dealtCard) && p.getChosenOrientation() == dealNumber) {
					System.out.println("Winner is found!");
					p.addWinnings(coinPot);
					System.out.println(p);
					return 1;
				}
			}
		}
		return -1;
	}
	
	public int play() {
		
		Scanner sc = new Scanner(System.in);
		
		// choosing a host randomly
		Random random = new Random();
		int hostIndex = random.nextInt(playerList.size());
		System.out.println(playerList.get(hostIndex).getName() + " is the HOST for this round."); 
		playerList.get(hostIndex).setHost(true);
		//playerList.remove(hostIndex);
		
		// players for this round
		//System.out.println("Player List: " + playerList);
		
		for(Player p: playerList) {
			if(!p.isHost()) {
				System.out.print(p.getName() + ", do you want to place a bet? [y/n]: ");
				char choice = sc.next().charAt(0);
				if(Character.toLowerCase(choice) == 'y') {
					System.out.println("Input your choice of card");
					System.out.print("Rank [1-13] where [1 = Ace, 11 = Jack, 12 = Queen, 13 = King]: ");
					int chosenRank = sc.nextInt() - 1;
					System.out.print("Suit [1 = Clubs, 2 = Diamonds, 3 = Hearts, 4 = Spades]: ");
					int chosenSuit = sc.nextInt() - 1;
					
					System.out.print("Input your choice of orientation [1 = in, 2 = out]: ");
					int chosenOrientation = sc.nextInt();
					
					System.out.print("Input your bet amount: ");
					int coinsBet = sc.nextInt();
					
					p.bet(new Card(chosenRank, chosenSuit), chosenOrientation, coinsBet);
					if(p.isPlacedBet())
						coinPot += coinsBet;
				}
			}
		}
		
		if(coinPot == 0) {
			System.out.println("Game cannot be played");
			return -1;
		}
		
		d.shuffleDeck();
		
		int dealNumber = 1;
		while(d.getCards().size() > 0) {
			int result;
			result = findWinner(d.dealCard(), dealNumber);
			if(result == 1) {
				return 1;
			}
			dealNumber++;
			if(dealNumber == 3)
				dealNumber = 1;
		}
		return -1;
	}

}
