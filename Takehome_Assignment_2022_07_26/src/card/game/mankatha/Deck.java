package card.game.mankatha;

import java.util.LinkedList;

public class Deck {

	private static final int NUMBER_OF_SUITS = 4;
	private static final int NUMBER_OF_RANKS = 13;
	private LinkedList<Card> cards;
	
	// building a deck of cards
	public Deck() {
		this.cards = new LinkedList<Card>();
		int i = 0;
		for(int suit = 0; suit < NUMBER_OF_SUITS; suit++) {
			for(int rank = 0; rank < NUMBER_OF_RANKS; rank++) {
				this.cards.add(new Card(rank, suit));
				i++;
			}
		}
	}
	
	public LinkedList<Card> getCards() {
		return cards;
	}

	public void shuffleDeck() {
		
	}
	
	// return the first card from the top of the deck
	public Card dealCard() {
		return this.cards.poll();
	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}
	
}
