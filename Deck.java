package edu.acc.java;

import java.util.Arrays;
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

	
	public Deck() {
		int i = 0;	
		for (String suit: PlayingCard.SUITS) {
				for (String rank: PlayingCard.RANKS) {
					deck[i] = new PlayingCard(rank, suit);
					i++;
			}
		}
		System.out.println("The length of the deck array is:" + deck.length + " cards.");
	}

	public PlayingCard[] deal(int numCards) {
		// Create PlayingCard (type) array called "Hand" of numCards length
		// Randomly pull a PlayingCard out of deck
		// Make sure the PlayingCard pulled is unique to the Hand array.
		// If unique, insert into Hand array
		// Return full hand
		
		int handMax = numCards;
		PlayingCard[] hand = new PlayingCard[handMax];
		Random rand = new Random();
		for (int i = 0; i < handMax; i++) {
			while (hand[i] == null) {
				PlayingCard card = new PlayingCard();
				card = deck[rand.nextInt(deck.length)];
				if (isUnique(hand, card))  {
					hand[i] = card;
					}
			}
		}
		return hand;			
	}
	
	public Boolean isUnique(PlayingCard[ ] cardArray, PlayingCard drawnCard)  {
		for (int i = 0; i < cardArray.length; i++)
	      {
	           if ( cardArray[i] == drawnCard )
	                 return false;
	      }
	     return true;
	}
	
			
	
	public static void main(String[] args) {
		int max = 6;
		Deck testDeck = new Deck();
		PlayingCard[] drawnHand = testDeck.deal(max);
		System.out.println("Hand drawn is " + Arrays.toString(drawnHand));
		
	}
}
