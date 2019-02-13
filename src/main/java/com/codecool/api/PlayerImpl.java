package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player{
    private String name;
   // private List<Card> cards;
    private Hand hand;
    private List<Card> wonCards;

    public PlayerImpl(String name) {
        wonCards = new ArrayList<>();
        this.name = name;
        hand = new Hand();
    }

    public void addWonCard(Card card) {
        wonCards.add(card);
    }

    public List<Card> getWonCards() {
        return wonCards;
    }

    @Override
    public boolean isEnough() {
        return false;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public String getName() {
        return name;
    }
}
