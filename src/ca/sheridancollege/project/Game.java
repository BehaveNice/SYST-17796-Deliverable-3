/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */

package ca.sheridancollege.project;

import java.util.*;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */

public class Game
{

    private final String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    private String gameDescription;
    private boolean isGameOver;

    
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName()
    {
        return gameName;
    }

    public String getGameDescription()
    {
        return gameDescription;
    }

    public String setGameDescription()
    {
        return gameDescription = "War is a simple card game, played by two players using a standard playing card deck. " +
                "The objective of the game is to win all of the cards.";
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public String play()
    {
        isGameOver = false;
        return "Game has started!";
    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public String end()
    {
        return "The game is over!";
    }

    public String declareWinner(String winner)
    {
        return "The winner is " + winner + "!";
    }

}//end class
