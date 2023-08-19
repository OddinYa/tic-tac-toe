package org.example.servis;

import org.example.model.Field;

public class Rules {

    private final int counterForVictory = 3;
    private final int counterToButtonClick = 8;
    private Field field;

    private int counterToFigureOnLine = 0;
    private char winner;

    private int row = 3;
    private int col = 3;

    public Rules() {
        field = Field.getInstance();
    }

    public boolean checkToWin(int xPos, int yPos) {
        boolean result = false;

        char charPlayer = field.getField()[xPos][yPos];

        if (checkLine(field, xPos, yPos, charPlayer)) {
            winner = field.getField()[xPos][yPos];
            result = true;

        }

        return result;

    }

    private boolean checkLine(Field fieldObj, int xPos, int yPos, char figure) {

        boolean won = false;

        char[][] field = fieldObj.getField();
        for (int i = 0, j = 0; i < 3 && j < 3; i++, j++) {
            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }
         won = countForWin();

        for (int i = 2, j = 2; i >= 0 && j >= 0; i--, j--) {
            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }
        if (!won) {
            won = countForWin();
        }


        for (int i = 1, j = 0; j < 3; j++) {

            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }

        if (!won) {
            won = countForWin();
        }

        for (int i = 0, j = 1; i < 3; i++) {
            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }
        if (!won) {
            won = countForWin();
        }

        for (int i = 0, j = 2; i < 3; i++) {
            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }
        if (!won) {
            won = countForWin();
        }
        for (int i = 0, j = 0; j < 3; j++) {
            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }
        if (!won) {
            won = countForWin();
        }
        for (int i = 0, j = 0; i < 3; i++) {
            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }
        if (!won) {
            won = countForWin();
        }
        for (int i = 2, j = 0; j < 3; j++) {
            if (figure == field[i][j]) {
                counterToFigureOnLine++;
            }
        }
        if (!won) {
            won = countForWin();
        }

        return won;
    }

    private boolean countForWin() {
        boolean result = counterToFigureOnLine == counterForVictory;
        counterToFigureOnLine = 0;
        return result;
    }

    public void setPos(int coutnClick, int xPos, int yPos) {

        char playerChar;

        if (coutnClick % 2 == 0) {
            playerChar = 'X';
        } else {
            playerChar = 'O';
        }

        field.setField(xPos, yPos, playerChar);
    }


    public int getCounterToButtonClick() {
        return counterToButtonClick;
    }

    public char getWinner() {
        return winner;
    }

    public Field getField() {
        return field;
    }
}
