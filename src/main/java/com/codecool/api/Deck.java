package com.codecool.api;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card>{

    private List<Card> cards;
    

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getDeck() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();

    }
}
