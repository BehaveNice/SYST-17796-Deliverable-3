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
        String computerPlayer = "Computer";

        WarPlayer playerOne = new WarPlayer(playerName);
        WarPlayer playerComputer = new WarPlayer(computerPlayer);

        System.out.println("Welcome " + playerOne.getPlayerID() + "\n");

        ArrayList<Player> players = new ArrayList<>();

        players.add(playerOne);
        players.add(playerComputer);
        war.setPlayers(players);

        ArrayList<Card> gameCards = new ArrayList<>();
        ArrayList<Card> playerOneCards = new ArrayList<>();
        ArrayList<Card> playerTwoCards = new ArrayList<>();

        GroupOfCards gameCardGroup = new GroupOfCards(gameCards, 52);
        GroupOfCards playerOneCardGroup = new GroupOfCards(playerOneCards, 26);
        GroupOfCards playerTwoCardGroup = new GroupOfCards(playerTwoCards, 26);

        System.out.println(gameCardGroup.getSize());

        gameCardGroup.setGroupOfCards(gameCards, gameCardGroup.getSize());

        gameCardGroup.shuffle();

        System.out.println(gameCardGroup.showCards(gameCards));

        playerOneCardGroup.distributeCards(playerOneCards, gameCards, 26);


    }
}
