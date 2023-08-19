package org.example.model;

public class Field {

    private int countToClick = 0;
    private static Field instance;
    private char[][] field;

    private Field(){
        field = new char[3][3];

    }
    public static Field getInstance() {
        if (instance == null) {
            instance = new Field();
        }
        return instance;
    }
    public int getCountToClick() {
        return countToClick;
    }

    public char[][] getField(){
        return field;
    }


    public void setField(int i,int j,char playerChar) {
        this.field[i][j] = playerChar;
        countToClick ++ ;
    }
}
