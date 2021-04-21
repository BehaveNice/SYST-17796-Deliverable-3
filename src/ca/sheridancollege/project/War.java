package ca.sheridancollege.project;

import java.util.*;

public class War
{
    public static void main(String[]args)
    {
        Scanner userInput = new Scanner(System.in);
        Game war = new Game("War");
        System.out.println("Welcome to the game of " + war.getGameName());
        war.setGameDescription();
        System.out.println(war.getGameDescription());
        System.out.println("\n" + "Please enter your name: ");

        String playerName = userInput.nextLine();
        WarPlayer playerOne = new WarPlayer(playerName);
        System.out.println("Welcome " + playerOne.getPlayerID() + "\n");

        Card[] gameCardDeck = new Card[52];
        Card[] playerOneDeck = new Card[26];
        Card[] playerTwoDeck = new Card[26];

        for(int i = 0; i < gameCardDeck.length; i++)
        {
            Card c = new Card();
            c.setValue((int)(Math.random()*13+4));
            c.setSuit(Card.SUITS[(int)(Math.random()*4)]);
            gameCardDeck[i] = c;
        }

        Collections.shuffle(Arrays.asList(gameCardDeck));

        for(int i = 0; i < playerOneDeck.length; i++)
        {
             playerOneDeck[i] = gameCardDeck[i];
        }

        for(int i = 0; i < playerTwoDeck.length; i++)
        {
            playerTwoDeck[i] = gameCardDeck[i + 25];
        }

        System.out.println(playerOne.getPlayerID() + ", your cards are:");
        for(int i = 0; i < playerOneDeck.length; i++)
        {
            System.out.println(playerOneDeck[i].getValue() + " of " + playerOneDeck[i].getSuit());
        }

        System.out.println();
        for(int i = 0; i < playerTwoDeck.length; i++)
        {
            System.out.println(playerTwoDeck[i].getValue() + " of " + playerTwoDeck[i].getSuit());
        }


    }
}
