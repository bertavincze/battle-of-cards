package com.codecool.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardComparatorTest {

    List<Card> cards;

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
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compare() {
        CardComparator comparator = new CardComparator(Attribute.MONEY);
        assertEquals(1, comparator.compare(cards.get(8), cards.get(9)));
    }
}
