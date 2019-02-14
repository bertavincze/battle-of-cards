package com.codecool.guiprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JPanel Panel1;
    private JProgressBar button1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        String name = JOptionPane.showInputDialog(frame, "Test");
        System.out.printf("The user's name is  '%s'.\n", name);

        /*
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(frame, "Enter your name");
            }
        });
        */

        frame.pack();
        frame.setVisible(true);
    }
}
