package com.codecool.api;

import java.util.List;
import java.util.Random;

public class Dealer {
    
    private Deck deck;
    
    public Dealer(Deck deck){
        this.deck = deck;
    }

    public void dealsTo(Player player) {
        while(deck.iterator().hasNext()){
            player.getHand().addCard(deck.iterator().next());
            deck.iterator().remove();
        }
    }
}
