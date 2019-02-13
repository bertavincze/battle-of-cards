package com.codecool.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TesztCardPrint {
    
    private static List<Card> cards;
    private static Deck deck;
    
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
            cards.add(new Card(strings[0], strings[1], Integer.valueOf(strings[2]),
                Integer.valueOf(strings[3]), Integer.valueOf(strings[4]),
                Money.valueOf(strings[5])));
        }
        deck = new Deck(cards);
        TesztCardPrint t = new TesztCardPrint();
        /*try {
            String[] image = fh.readTxt("resources/image2Players.txt");
            for (int i = 0; i < image.length; i++) {
                System.out.println(image[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        t.showCards(cards);
    
    }
    
    public void showCards(List<Card> cards) {
        
        //String header = "+--------------------+ ".repeat(cards.size());
        String closer = "|____________________| ".repeat(cards.size());
        String broccoli = "| megevett brokkoli: | ".repeat(cards.size());
        String apu =      "| apu foglalkozása:  | ".repeat(cards.size());
        String emptyRow = "|                    | ".repeat(cards.size());
        String graphic1 = "        //////         ".repeat(cards.size());
        String graphic2 = "       ( O O )         ".repeat(cards.size());
        String graphic3 = "|--ooO--- ˘ ---Ooo---| ".repeat(cards.size());
    
    
        String cardField = "| %-18s |";
        
        String cardField1 = IntStream.range(0, cards.size()).mapToObj(i -> cardField + " ").collect(Collectors.joining()) + "%n";
        
        //System.out.println(header);
        System.out.println(graphic1);
        System.out.println(graphic2);
        System.out.println(graphic3);
        System.out.println(emptyRow);
        System.out.printf(cardField1, cards.stream().map((Card c) -> "jel: " + c.getId()).toArray());
        System.out.printf(cardField1, cards.stream().map((Card c) -> "név: " + c.getName()).toArray());
        System.out.println(emptyRow);
        System.out.println(broccoli);
        System.out.printf(cardField1, cards.stream().map((Card c) -> c.getEatedBrokkoliInKg() + "kg").toArray());
        System.out.println(emptyRow);
        System.out.printf(cardField1, cards.stream().map((Card c) -> ("testsúly: " + c.getWeight()) + "kg").toArray());
        System.out.println(emptyRow);
        System.out.printf(cardField1, cards.stream().map((Card c) -> ("vödör: " + c.getSandBucketSize()) + " literes").toArray());
        System.out.println(emptyRow);
        System.out.println(apu);
        System.out.printf(cardField1, cards.stream().map((Card c) -> c.getMoney()).toArray());
        System.out.printf(closer);
    }
}
