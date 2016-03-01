package edu.acc.java;

import java.util.Random;

/**
 * 1) Implement a Deck class with an array of 52 unique PlayingCard instances.
 * 2) Write a PlayCard[] deal (int numCardsInHand) method taking random cards from deck
 *    Note:  Make sure you don't return the same card twice
 *    
 * 3) Write a main() to test
 * @author JavaUser
 *
 */

public class Deck extends PlayingCard {
	
	private PlayingCard[] deck = new PlayingCard[52];
	// private int cardsPerPlayer = 5;
	private PlayingCard card;
	
	public Deck() {
		int i = 0;	
		for (String suit: PlayingCard.SUITS) {
				for (String rank: PlayingCard.RANKS) {
					deck[i] = new PlayingCard(rank, suit);
					i++;
			}
		}
		System.out.println("The length of the deck array is:");
		System.out.println(deck.length + "cards.");
	}

	public PlayingCard[] deal(int numCards) {
		// Create PlayingCard (type) array called "Hand" of numCards length
		// Randomly pull a PlayingCard out of deck and insert into Hand if unique
		// Return full hand
		int handMax = numCards;
		PlayingCard[] hand = new PlayingCard[handMax];
		Random rand = new Random();
		//this.card = deck[rand.nextInt(deck.length)];
	}
	
		
		
	
	public static void main(String[] args) {
		Deck testDeck = new Deck();
		
	}
}
