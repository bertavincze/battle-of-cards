package com.codecool.cmdprog;

import com.codecool.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableTwoPlayer extends Table {
    private Player player;
    private Player playerAI;
    private Dealer dealer;
    private Deck deck;

    public void playGame(Scanner reader, Deck deck) {
        dealer = new Dealer(deck);
        System.out.println("Please give your name: ");
        String name = reader.nextLine();

        //We create the user player and a computer player
        player = new PlayerImpl(name);
        playerAI = new PlayerImpl("computer");

        //Dealer deal 5 cards to each players
        dealer.dealsTo(player, 4);
        dealer.dealsTo(playerAI, 4);

        simulationOneRound();

    }

    public  void printCurrentCards(List<Card> playerCards) {
        int count = 1;
        for (Card element : playerCards) {
            System.out.println(count + ". " + element.toString());
            count++;
        }
    }

    public void simulationOneRound() {
        //Show player his/her cards
        List<Card> playerCards = player.getHand().getCards();
        List<Card> computerCards = playerAI.getHand().getCards();
        printCurrentCards(playerCards);
        Attribute randAttribute = decideAttribute();
        System.out.println("Please choose one of your cards (the attribute the cards will be compared in this round is: " + randAttribute );
        askForCardFromUser(playerCards);
        askCardFromComputer(computerCards, randAttribute);
    }

    public Card askForCardFromUser(List<Card> playerCards) {
        int num1;
        while(true) {
            System.out.println("Choose a card (1-4): ");
            String num = sc.nextLine();

            if (!isInteger(num)) {
                num1 = Integer.parseInt(num);
                if (num1 > 0 && num1 <= playerCards.size()) {
                    break;
                }
            }
        }
        return playerCards.get(num1-1);
    }

    public void askCardFromComputer(List<Card> computerCards, Attribute attribute) {
        ;

    }

    protected boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
