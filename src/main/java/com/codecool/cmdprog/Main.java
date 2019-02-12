package com.codecool.cmdprog;

import com.codecool.api.FileHandler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //new Table().newGame();
        FileHandler fh = new FileHandler();
        try {
            String[] image = fh.readTxt("resources/image.txt");
            for (int i = 0; i < image.length; i++) {
                System.out.println(image[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
