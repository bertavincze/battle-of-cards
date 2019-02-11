package com.codecool.api;

import java.util.List;
import java.util.Random;

public class Dealer {
    private List<Card> deck;
    private Card card;

    public void randomChoose() {
        Random r = new Random();
    }

    public void dealsTo(Player player) {
        player.getHand().addCard(card);
    }
}
