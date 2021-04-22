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

        System.out.println("\n" + war.play());
        int lowestCardSize = 52;
        int playerOneDeckSize = 26;
        int playerTwoDeckSize = 26;


        for (int i = 0; i < lowestCardSize; i++)
            {
                if (playerOneCards.get(i).getValue() > playerTwoCards.get(i).getValue())
                {
                    System.out.println("----------------------------");
                    System.out.println("\n" + gameCardGroup.toString(playerName, playerOneCards.get(i).getValue(), playerOneCards.get(i).getSuit()));
                    System.out.println(gameCardGroup.toString(computerPlayer, playerTwoCards.get(i).getValue(), playerTwoCards.get(i).getSuit()));
                    System.out.println("The " + playerOneCards.get(i).getValue() + " of " + playerOneCards.get(i).getSuit() + " is of higher value!");
                    System.out.println("\n" + playerName + " wins this round!" + "\n");
                    playerOneDeckSize = playerOneDeckSize + 1;
                    playerTwoDeckSize = playerTwoDeckSize - 1;
                    playerOneCards.add(playerTwoCards.get(i));
                    playerTwoCards.remove(i);
                    if (playerOneCards.size() > playerTwoCards.size())
                    {
                        lowestCardSize = playerTwoCards.size();
                    }
                }
                else if (playerOneCards.get(i).getValue() < playerTwoCards.get(i).getValue())
                {
                    System.out.println("----------------------------");
                    System.out.println("\n" + gameCardGroup.toString(playerName, playerOneCards.get(i).getValue(), playerOneCards.get(i).getSuit()));
                    System.out.println(gameCardGroup.toString(computerPlayer, playerTwoCards.get(i).getValue(), playerTwoCards.get(i).getSuit()));
                    System.out.println("The " + playerTwoCards.get(i).getValue() + " of " + playerTwoCards.get(i).getSuit() + " is of higher value!");
                    System.out.println("\n" + "The " + computerPlayer + " wins this round!" + "\n");
                    playerTwoDeckSize = playerTwoDeckSize + 1;
                    playerOneDeckSize = playerOneDeckSize - 1;
                    playerTwoCards.add(playerOneCards.get(i));
                    playerOneCards.remove(i);
                    if(playerTwoCards.size() > playerOneCardGroup.getSize())
                    {
                        lowestCardSize = playerOneCards.size();
                    }
                }
                else
                {
                    System.out.println("----------------------------");
                    System.out.println("\n" +"This round is a tie!" + "\n");
                }
            }


        System.out.println("\n" + war.end());

        if(playerOneDeckSize > playerTwoDeckSize)
        {
            System.out.println("\n" + war.declareWinner(playerName));
        }
        else
        {
            System.out.println("\n" + war.declareWinner("The " + computerPlayer));
        }
    }
}
