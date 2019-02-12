package com.codecool.cmdprog;

import com.codecool.api.Dealer;
import com.codecool.api.Deck;
import com.codecool.api.Player;
import com.codecool.api.PlayerImpl;

import java.util.Scanner;

public class TableTwoPlayer extends Table {
    private Player player;
    private Player playerAI;
    private Dealer dealer;
    private Deck deck;

    public void playGame(Scanner reader) {
        deck = new Deck();
        dealer = new Dealer();
        System.out.println("Please give your name: ");
        String name = reader.nextLine();
        player = new PlayerImpl(name);

        playerAI = new PlayerImpl("computer");

        dealer.dealsTo(player, 5);
        dealer.dealsTo(playerAI, 5);
    }
}
