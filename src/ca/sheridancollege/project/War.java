package ca.sheridancollege.project;

import java.util.*;

public class War
{
    public static void main(String[]args)
    {
        Scanner userInput = new Scanner(System.in);
        Game war = new Game("War");
        System.out.println("Welcome to the game of " + war.getGameName());
        System.out.println("Please enter your name: ");
        String name = userInput.nextLine();

        Card[] gameCardDeck = new Card[26];
        for(int i = 0; i < gameCardDeck.length; i++)
        {
            Card c = new Card();
            c.setValue((int)(Math.random()*13+4));
            c.setSuit(Card.SUITS[(int)(Math.random()*4)]);
            gameCardDeck[i] = c;
        }
        Collections.shuffle(Arrays.asList(gameCardDeck));
        for(int i = 0; i < gameCardDeck.length; i++)
        System.out.println(gameCardDeck[i].getValue() + " of " + gameCardDeck[i].getSuit());


    }
}
