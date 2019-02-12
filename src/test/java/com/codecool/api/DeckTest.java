package com.codecool.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    List<Card> cards;
    Deck deck;

    @BeforeEach
    void setUp() throws IOException {
        FileHandler fh = new FileHandler();
        String[][] cardsArray = fh.read("resources/cards.csv");
        this.cards = new ArrayList<>();
        for (String[] strings : cardsArray) {
            cards.add(new Card(strings[0], strings[1], Rank.valueOf(strings[2]),
                Integer.valueOf(strings[3]), Integer.valueOf(strings[4]),
                Money.valueOf(strings[5])));
        }
        this.deck = new Deck(cards);
    }

    @Test
    void getDeck() {
        assertEquals(deck.getDeck().get(0).getId(), new Card("gombácska", "Pistike",
            Rank.FIRSTYEAR, 17, 1, Money.BENEFIT).getId());
    }

    @AfterEach
    void tearDown() {

    }
}
