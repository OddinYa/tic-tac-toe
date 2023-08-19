package org.example.servis;

import org.example.model.Field;

public class Rules {

    private final int counterForVictory = 3;
    private final int counterToButtonClick = 9;
    private Field field;

    private char winner;

    private int row = 3;
    private int col = 3;

    public Rules(){
        field = Field.getInstance();
    }

    public boolean checkToWin(int xPos,int yPos) {
        boolean result = false;

        char charPlayer = field.getField()[xPos][yPos];

        if(counterForVictory == checkLine(field,xPos,yPos,charPlayer)) {
            winner = field.getField()[xPos][yPos];
            result = true;

        }


        return result;

    }

    private int checkLine(Field fieldObj,int xPos,int yPos,char figure){
        int counterToFigureOnLine = 0;

        char[][] field = fieldObj.getField();

        if(xPos== 1 && yPos == 1){
            for (int i = 0,j = 0; i < 3 && j < 3 ; i++,j++) {
                if(figure == field[i][j]){
                    counterToFigureOnLine++;
                }
            }

        }
        else if(xPos == 1 && yPos == 0
                || xPos == 2 && yPos == 1
                || xPos == 1 && yPos == 2
                || xPos == 0 && yPos == 1)
        {


        }else {


        }



        return counterToFigureOnLine;
    }
    public void setPos(int coutnClick,int xPos, int yPos){

        char playerChar;

        if(coutnClick%2==0){
            playerChar = 'X';
        }
        else{
            playerChar = 'O';
        }

        field.setField(xPos,yPos,playerChar);
    }


    public int getCounterToButtonClick() {
        return counterToButtonClick;
    }

    public char getWinner() {
        return winner;
    }
}
