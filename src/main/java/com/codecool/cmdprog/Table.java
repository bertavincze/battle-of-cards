package com.codecool.cmdprog;

import com.codecool.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    public static List<Card> cards;
    public static Deck deck;
    
    
    public static void main(String[] args) {
        
        FileHandler fh = new FileHandler();
        String[][] cardsArray = new String[0][];
        try {
            cardsArray = fh.read("resources/cards.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cards = new ArrayList<>();
        for (String[] strings : cardsArray) {
            cards.add(new Card(strings[0], strings[1], Rank.valueOf(strings[2]),
                Integer.valueOf(strings[3]), Integer.valueOf(strings[4]),
                Money.valueOf(strings[5])));
        }
        deck = new Deck(cards);
        Table t = new Table();
        t.showCards(cards);
        
    }
    
    public void newGame(){
    
    }
    
    public void showCards(List<Card> cards) {
        
        
        
        String leftAligned = "| %-18s | | %-18s |%n";
        String header = " ____________________   ____________________";
        String closer = " --------------------   --------------------";
        String graphic1 = "|-------//////-------| |-------//////-------|";
        String graphic2 = "|------( O O )-------| |------( O O )-------|";
        String graphic3 = "|--ooO---( )---Ooo---| |--ooO---( )---Ooo---|";

        System.out.println(graphic1);
        System.out.println(graphic2);
        System.out.println(graphic3);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "jel:" + cards.get(0).getId(),"jel:" + cards.get(1).getId());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "név:" + cards.get(0).getName(), "név:" + cards.get(1).getName());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "csoport:" + cards.get(0).getRank(), "csoport:" + cards.get(1).getRank());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "súly: " + cards.get(0).getWeight() + "kg", "súly: " + cards.get(1).getWeight() + "kg");
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "vödör:" + cards.get(0).getSandBucketSize() + " literes", "vödör:" + cards.get(0).getSandBucketSize() + " literes");
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "apu foglalkozása:", "apu foglalkozása:");
        System.out.printf(leftAligned, cards.get(0).getMoney(), cards.get(1).getMoney());
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(closer);
    }
}
