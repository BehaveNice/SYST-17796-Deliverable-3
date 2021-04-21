/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(ArrayList<Card> givenCardArray, int givenSize)
    {
        cards = givenCardArray;
        size = givenSize;
    }

    public ArrayList<Card> setGroupOfCards(ArrayList<Card> cards, int givenSize)
    {
        for(int i = 0; i < givenSize; i++)
        {
            cards.add(new Card(Card.SUITS[(int)(Math.random()*4)], (int)Math.random()*13+4));
        }
        return cards;
    }

    public void distributeCards(ArrayList<Card> playerOneCards, ArrayList<Card> playerTwoCards, ArrayList<Card> deckCards, int givenSize)
    {
        for(int i = 0; i < givenSize; i++)
        {
            playerOneCards.add(deckCards.get(i));
            playerTwoCards.add(deckCards.get(i + 25));
        }
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize()
    {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize)
    {
        size = givenSize;
    }
    
}//end class
