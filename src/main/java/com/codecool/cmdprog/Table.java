package com.codecool.cmdprog;

import com.codecool.api.Card;
import jdk.internal.joptsimple.internal.Strings;

import java.util.List;

public class Table {
    
    public void newGame(){
    
    }
    
    public void showCards(List<Card> cards){
        String id= "gombácska";
        int wide = 20;
        String header = Strings.repeat('_', 20);
        String emptyRow = "|"+ Strings.repeat(' ',18)+"|\n";
        
        
        // nincs kész!
        String cardPrint = header + emptyRow +
                           "| jel: " + id;
    }
}
