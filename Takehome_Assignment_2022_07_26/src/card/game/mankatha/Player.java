package card.game.mankatha;

public class Player {
	
	private String name;
	private static final int INITIAL_COINS = 100;
	private int coins;
	private Card chosenCard;
	//private static final String[] ORIENTATION = {"in", "out"};
	private int chosenOrientation;
	private boolean isHost;
	private boolean placedBet;
	
	public Player() {
		// default constructor
		this.coins = INITIAL_COINS;
		this.isHost = false;
		this.placedBet = false;
	}
	
	public Player(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getCoins() {
		return coins;
	}
	
	public boolean isValidAmount(int coinsBet) {
		if(coinsBet <= coins)
			return true;
		return false;
	}
	
	public Card getChosenCard() {
		return chosenCard;
	}

	public int getChosenOrientation() {
		return chosenOrientation;
	}

	public boolean isHost() {
		return isHost;
	}

	public void setHost(boolean isHost) {
		this.isHost = isHost;
	}

	public boolean isPlacedBet() {
		return placedBet;
	}

	public void setPlacedBet(boolean placedBet) {
		this.placedBet = placedBet;
	}

	public void bet(Card chosenCard, int chosenOrientation, int coinsBet) {
		if(isValidAmount(coinsBet)) {
			this.chosenCard = chosenCard;
			this.chosenOrientation = chosenOrientation;
			this.coins -= coinsBet;
			this.placedBet = true;
			System.out.println(this.name + ": " + this.chosenCard + ", " + this.chosenOrientation + ", " + coinsBet + ", Bet Placed Successfully!");
			
		}
	}
	
	public void addWinnings(int coinsWon) {
		this.coins += coinsWon;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", coins=" + coins + "]";
	}
	
}
