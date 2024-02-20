/**
 * 
 * @author Josh Babbitt
 * Project PokerHand
 *
 */
public class Deck 
{
	
	/*
	 * TODO create a Card array field which represents the cards
	 * in the deck.   Also create an int field called nextToDeal
	 * which will identify the next index to deal. This field will
	 * start at 0 and will be incremented each time a card is "dealt".
	 * when nextToDeal = the length of cards, there are no cards left
	 * to deal
	 * 
	 */
	Card[] cards;
	int nextToDeal = 0;
	
	/*
	 * TODO create a deck constructor which requires no arguments.
	 * The constructor will generate a standard deck of playing
	 * cards. The values of the playing cards will be from 2-14 where
	 * a rank of "2" has a value of 2 and a rank of "A" has a value 
	 * of 14.
	 * 
	 * I suggest creating arrays for all possible values, ranks, and
	 * suits.   You can then use two nested for loops to create the deck
	 * 
	 */
	Deck()
	{
		Card[] deck = new Card[52];
		char[] suits = {'S','C','D','H'};
		String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
		deck = new Card[52];
		int index = 0;
		for (int i=0; i < suits.length; i++)
		{
			for (int j=0; j < ranks.length; j++)
			{
				Card card1 = new Card(suits[i],ranks[j],values[j]);
				deck[index] = card1;
				index++;
			}
		}
	}
	
	/*
	 * TODO create a method called shuffle which will arrange all cards
	 * in the array cards in a random order and reset nextToDeal to zero.
	 * 
	 */
	public Card[] shuffle()
	{
		for(int i = 0; i < 52;i++)
		{
			int randNum = (int)(Math.random()*52);
			Card temp = cards[i];
			cards[i] = cards[randNum];
			cards[randNum] = temp;
		}
		nextToDeal = 0;
		return cards;
	}
	/*
	 * TODO create a method called deal which takes no arguments. 
	 * it should return the card at nextToDeal and increment the field
	 * nextToDeal.  If there are no cards left to deal, return null.
	 */
	public Card deal()
	{
		if(nextToDeal<53)
			return cards[nextToDeal];
		else
			return null;
	}
	
}
