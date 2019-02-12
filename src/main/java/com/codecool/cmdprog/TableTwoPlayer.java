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
        for (Card element : playerCards) {
            System.out.println(element.toString());
        }
    }

    public void simulation() {
        //Show player his/her cards
        List<Card> playerCards = player.getHand().getCards();
        printCurrentCards(playerCards);

        System.out.println("Please choose one of your cards (the attribute the cards will be compared in this round is: ");
    }
}
