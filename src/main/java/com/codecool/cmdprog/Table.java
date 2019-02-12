package com.codecool.cmdprog;

import com.codecool.api.Card;

import java.util.ArrayList;
import java.util.List;

public class Table {
    
    private List<Card> cards;
    
    public void newGame(){
    
    }
    
    private List<Card> getCards(){
        return this.cards;
    }
    private void setCards(){ // még nincs kész!
        this.cards = new ArrayList<>();
    }
    public static void main(String[] args){
        String leftAligned = "| %-18s | | %-18s |%n";
        String header = " ____________________   ____________________";
        String closer = " --------------------   --------------------";
        String id= "gombácska";
        String name = "józsi";
        String rank = "firstyear";
        String bucketSize = "13";
        String weight = "20";
        System.out.println(header);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "id:" + id,"id:" + id);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "name:" + name, "name:" + name);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "rank:" + rank, "rank:" + rank);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "weight:" + weight, "weight:" + weight);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(leftAligned, "bucket:" + bucketSize, "bucket:" + bucketSize);
        System.out.printf(leftAligned, " ", " ");
        System.out.printf(closer);
    
    }
    
    public void showCards(List<Card> cards){
        String leftAligned = "| %-18s |%n";
        String header = "___________________";
        String id= "gombácska";
        int wide = 20;
        System.out.printf("");
        
        // nincs kész!
        String cardPrint;
    }
    
}
