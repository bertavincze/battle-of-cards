package com.codecool.api;

import java.util.List;

public class PlayerImpl implements Player{
    private String name;
   // private List<Card> cards;
    private Hand hand;

    public PlayerImpl(String name) {
        this.name = name;
        hand = new Hand();
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
