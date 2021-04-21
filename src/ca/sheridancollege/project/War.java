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

        gameCardGroup.setGroupOfCards(gameCards, gameCardGroup.getSize());

        gameCardGroup.shuffle();

        playerOneCardGroup.distributeCards(playerOneCards, playerTwoCards, gameCards, 26);
        playerTwoCardGroup.distributeCards(playerTwoCards, playerOneCards, gameCards, 26);

        System.out.println(playerName +  " your cards are: ");

        for (Card cards : playerOneCardGroup.showCards())
        {
            System.out.println(cards.getValue() + " of " + cards.getSuit());
        }

        System.out.println("\n" + war.play());
        int lowestCardSize = 52;
        {
            for (int i = 0; i < lowestCardSize; i++)
            {
                if (playerOneCards.get(i).getValue() > playerTwoCards.get(i).getValue()) {
                    System.out.println(playerName + " wins this round!");
                    playerOneCards.add(playerTwoCards.get(i));
                    playerTwoCards.remove(i);

                    if(playerOneCards.size() > playerTwoCards.size())
                    {
                        lowestCardSize = playerTwoCards.size();
                    }
                } else if (playerOneCards.get(i).getValue() < playerTwoCards.get(i).getValue()) {
                    System.out.println(computerPlayer + " wins this round!");
                    playerTwoCards.add(playerOneCards.get(i));
                    playerOneCards.remove(i);
                    if(playerTwoCards.size() > playerOneCardGroup.getSize())
                    {
                        lowestCardSize = playerOneCards.size();
                    }
                } else if (playerOneCards.get(i).getValue() == playerTwoCards.get(i).getValue()) {
                    System.out.println("This round is a tie!");
                } else {
                    System.out.println("No one is the winner");
                    break;
                }
            }
        }

        System.out.println("\n" + war.end());
        if(playerOneCards.size() > playerTwoCards.size())
        {
            System.out.println(war.declareWinner(playerName));
        }
        else
        {
            System.out.println("\n" + war.declareWinner("The " + computerPlayer));
        }
        System.out.println(playerTwoCards.size());
        System.out.println(playerOneCards.size());
    }
}
