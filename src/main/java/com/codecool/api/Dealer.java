package com.codecool.api;

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
