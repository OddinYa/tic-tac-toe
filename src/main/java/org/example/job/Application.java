package org.example.job;

import org.example.display.ButtonGrid;

import javax.swing.*;

public class Application {

    public static void runApp(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonGrid();
            }
        });
    }

}
