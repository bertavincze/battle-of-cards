package com.codecool.api;

import java.util.List;
import java.util.Random;

public class Dealer {

    private Deck deck;

    public Dealer(Deck deck){
        this.deck = deck;
    }

    public void dealsTo(Player player, int numberOfCards) {

        while(deck.iterator().hasNext()){
            for (int i = 0; i < numberOfCards; i++) {
                player.getHand().addCard(deck.iterator().next());
                deck.iterator().remove();
            }
        }
    }
}
