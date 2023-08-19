package org.example.model;

public class Field {

    private static Field instance;
    private char[][] field;

    private Field(){
        field = new char[3][3];
        filling(field);
    }
    public static Field getInstance() {
        if (instance == null) {
            instance = new Field();
        }
        return instance;
    }

    private void filling(char[][] field){

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';
            }
        }
    }




}
