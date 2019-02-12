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

        simulation();

    }

    public  void printCurrentCards(List<Card> playerCards) {
        int count = 1;
        for (Card element : playerCards) {
            System.out.println(count + ". " + element.toString());
            count++;
        }
    }

    public void simulation() {
        //Show player his/her cards
        List<Card> playerCards = player.getHand().getCards();
        printCurrentCards(playerCards);
        Attribute randAttribute = decideAttribute();
        System.out.println("Please choose one of your cards (the attribute the cards will be compared in this round is: " + randAttribute );
        askForCardFromUser();
        askCardFromComputer();
    }

    public void askForCardFromUser() {
        while(true) {
            System.out.println("Choose a card (1-4): ");
            String num = sc.nextLine();
            switch (num) {
                case "1":
                case "2":
                case "3":
                case "4":
                default: System.out.println("Invalid option!");
                        break;
            }
        }
    }

    public void askCardFromComputer() {
        
    }
}
