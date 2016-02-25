package edu.acc.java;

public class PlayingCard {
	
	private String rank;
	private String suit;
	private static String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King", "Ace"};
	private static String[] suits = {"Club", "Diamond", "Heart", "Spade"};
		
	public PlayingCard(String r, String s) {
		System.out.println("In PlayingCard(int r, int s) constructor.");
		this.rank = r;
		this.suit = s;
		System.out.println("Just created a PlayingCard:  " + this.rank + " of " + this.suit + "s.");
	}

		public String getRank(int ranksElement) {
			this.rank = this.ranks[ranksElement];
			return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit(int suitsElement) {
		this.suit = this.suits[suitsElement];
		return this.suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public static void main(String[] args) {
		PlayingCard cardOne = new PlayingCard("3","Club");
		for (String rank: ranks) {
		}
			
		}
	}

}
