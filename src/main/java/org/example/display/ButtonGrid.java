package org.example.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGrid {


    private JFrame frame;
    private JButton[][] buttons;

    public ButtonGrid() {
        frame = new JFrame("Tic-tac-toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                frame.add(buttons[i][j]);
            }
        }

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setText("Clicked (" + row + ", " + col + ")");
        }
    }
}