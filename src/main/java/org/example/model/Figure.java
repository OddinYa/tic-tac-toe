package org.example.model;

public class Figure {
    private String path;


    public Figure(int countClick){
        if(countClick%2==0){
            this.path = "D:\\Users\\tic-tac-toe\\X.png";
        }else {
            this.path = "D:\\Users\\tic-tac-toe\\O.png";
        }
    }


    public String getPath() {
        return path;
    }
}
