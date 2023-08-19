package org.example.display;

import org.example.job.Application;
import org.example.model.Field;
import org.example.model.Figure;
import org.example.servis.Rules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class ButtonGrid {

    private Rules rules = new Rules();
    private JFrame frame;
    private JButton[][] buttons;
    private int clickCount = 0;


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

            buttons[row][col].setIcon(new ImageIcon(new Figure(clickCount).getPath()));
            rules.setPos(clickCount, row, col);

            if (rules.checkToWin(row,col)) {

                int option = JOptionPane.showOptionDialog(null, "Игрок " + rules.getWinner() + " Победил! Хотите сыграть еще?", "Победа", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Сыграть еще", "Выход"}, "Сыграть еще");

                if (option == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    rules.getField().clear();
                    Application.runApp();

                } else {
                    exit(0);
                }
            }
            else if(rules.getCounterToButtonClick() == clickCount){
                int option = JOptionPane.showOptionDialog(null, "Ничья! Хотите сыграть еще?", "Победа", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Сыграть еще", "Выход"}, "Сыграть еще");

                if (option == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    rules.getField().clear();
                    Application.runApp();

                } else {
                    exit(0);
                }
            }

            clickCount++;
        }


    }
}



