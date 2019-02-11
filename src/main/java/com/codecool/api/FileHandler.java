package com.codecool.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    public String[][] read(String file) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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

        } catch (IOException f) {
            System.out.println(f.getMessage());
            return null;
        }
    }

    public int countLines(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                br.readLine();
                i++;
            }
            return i;

        } catch (IOException f) {
            System.out.println(f.getMessage());
            return 0;
        }
    }

    public int countCols(String file) {
        int i;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String countFieldString = br.readLine();
            i = countFieldString.length() - countFieldString.replace(",", "").length() + 1;
            return i;

        } catch (IOException f) {
            System.out.println(f.getMessage());
            return 0;
        }
    }
}
