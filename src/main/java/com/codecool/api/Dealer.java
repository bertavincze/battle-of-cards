package com.codecool.api;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Dealer {

    private Deck deck;

    public Dealer(Deck deck){
        this.deck = deck;
    }

    public void dealsTo(Player player, int numberOfCards) {
        Iterator<Card> it = deck.iterator();
        for (int i = 0; i < numberOfCards; i++) {
            player.getHand().addCard(it.next());
            it.remove();
        }
    }

    public Deck getDeck() {
        return deck;
    }
}
