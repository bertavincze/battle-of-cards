package com.codecool.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileHandler {

    public String[][] read(String file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String[][] data = new String[0][0];
        while (br.ready()) {
            int numOfLines = countLines(file);
            int numOfFields = countCols(file);

            data = new String[numOfLines][numOfFields];
            for (int i = 0; i < numOfLines; i++) {
                data[i] = br.readLine().split(",");
            }
        }
        return data;
    }

    public String[] readTxt(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int numOfLines = countLines(filename);
        String[] outputArray = new String[numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            outputArray[i] = br.readLine();
        }
        return outputArray;
    }

    public int countLines(String file) throws IOException {
        int i = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while (br.ready()) {
            br.readLine();
            i++;
        }
        return i;
    }

    public int countCols(String file) throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String countFieldString = br.readLine();
        i = countFieldString.length() - countFieldString.replace(",", "").length() + 1;
        return i;

    }
}
