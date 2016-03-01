package edu.acc.java;

public interface PlayingCardIF {
	// These are implicitly abstract -- no body defined here.  public modifier not necessary here.
	// Everything in an interface is public.
	// Just list methods (behavior) you're promising (a contract) will have:
	String toString();
	String getRank(int ranksElement);
	void setRank(String rank);
	String getSuit(int suitsElement);
	void setSuit(String suit);

}
