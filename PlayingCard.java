package edu.acc.java;
import java.util.Random;

public class PlayingCard implements PlayingCardIF {
	
	private String rank;
	private String suit;
	//Consider making the following "final" since you know those values won't change.
	final static String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	final static String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
		
	public PlayingCard(String r, String s) {
		System.out.println("In PlayingCard(String r, String s) constructor.");
		this.rank = r;
		this.suit = s;
		System.out.println("Just created a PlayingCard:  " + this.rank + " of " + this.suit);
	}

	public PlayingCard() {
		// no rank or suit given so randomize a card
		Random rand = new Random();
		this.suit = SUITS[rand.nextInt(SUITS.length)];
		this.rank = RANKS[rand.nextInt(RANKS.length)];
		System.out.println("Just created a PlayingCard:  " + this.rank + " of " + this.suit);
	}
	
	public String getRank(int ranksElement) {
			this.rank = PlayingCard.RANKS[ranksElement];
			return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit(int suitsElement) {
		this.suit = PlayingCard.SUITS[suitsElement];
		return this.suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	@Override
	// System.out.println(objectName) will reference this implicitly.
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	
	public static void main(String[] args) {
		PlayingCard cardOne = new PlayingCard("3","Clubs");
		System.out.println(cardOne);
		PlayingCard cardTwo = new PlayingCard();
		System.out.println(cardTwo);
		for (String suit: SUITS) {
			for (String rank: RANKS) {
				System.out.println(rank + " of " + suit);
			}
		}
			
	}

}
