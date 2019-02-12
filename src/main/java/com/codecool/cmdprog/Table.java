package com.codecool.cmdprog;

import com.codecool.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
    public static List<Card> cards;
    public static Deck deck;
    private final Scanner sc = new Scanner(System.in);

    public void newGame() {
        Menu menu = new Menu("Menu", new String[]{"Simulate a game", "Play a game", "Exit"});
        while (true) {
            menu.displayMenu();
            switch (sc.nextLine()) {
                case "1":
                    // some method
                case "2":
                    new TableTwoPlayer().playGame(sc);
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

    }
    
    /*
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
        try {
            String[] image = fh.readTxt("resources/image2Players.txt");
            for (int i = 0; i < image.length; i++) {
                System.out.println(image[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.showCards(cards);
        
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
    */
}
