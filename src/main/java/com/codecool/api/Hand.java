package com.codecool.api;

import java.util.List;

public class Hand {

    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
