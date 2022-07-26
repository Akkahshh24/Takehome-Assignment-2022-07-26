package card.game.mankatha;

public class Card {
	
	private static final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7",
			 								"8", "9", "10", "Jack", "Queen", "King"};
	 
	private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	private int rank;
	private int suit;
	
	public Card() {
		// default constructor
	}
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}
	
	public boolean equals(Card that) {
	    return this.rank == that.rank && this.suit == that.suit;
	}
	
	public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
}
