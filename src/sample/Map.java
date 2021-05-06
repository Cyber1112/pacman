package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Calendar;
import java.util.Scanner;

public class Map {
    Pane pane = new Pane();
    private String[][] arr;
    private int size = 8;
    private int x, y;
    Position pos;
    Circle pacman;
    public Map(Scanner readFile){
        pane.setStyle("-fx-background-color: white");
        arr = new String[size][size];
        for(int i = 0; i < size;  i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = readFile.next();
                if(arr[i][j].equals("P") || arr[i][j].equals("0") || arr[i][j].equals("1")){
                    if(arr[i][j].equals("P")){
                        pos = new Position(j, i);
                        this.x = j;
                        this.y = i;
                        pacman = new Circle();
                        pacman.setFill(Color.RED);
                        pacman.setRadius(25);
                        pacman.setCenterX(i*50 + 25);
                        pacman.setCenterY(j*50 + 25);
                        pane.getChildren().add(pacman);
                    }else if (arr[i][j].equals("0")){
                        Rectangle rect = new Rectangle();
                        rect.setStroke(Color.BLACK);
                        rect.setFill(Color.WHITE);
                        rect.setHeight(50);
                        rect.setWidth(50);
                        rect.setX(j*50);
                        rect.setY(i*50);
                        pane.getChildren().add(rect);
                    }else if(arr[i][j].equals("1")){
                        Rectangle wall = new Rectangle();
                        wall.setWidth(50);
                        wall.setHeight(50);
                        wall.setFill(Color.BLACK);
                        wall.setStroke(Color.BLACK);
                        wall.setX(j*50);
                        wall.setY(i*50);
                        pane.getChildren().add(wall);
                    }
                }else{
                    System.out.println("Not Enough Map elemetns");
                }
            }
        }
    }
    public int getSize() {
        return this.size;
    }
    public Pane getMap(){
        return pane;
    }
    public char getValueAt(int x, int y) {
        this.x = x;
        this.y = y;
        return arr[y][x].charAt(0);
    }
    public void setPositionPacman(Position positionCurrent){
        this.x = positionCurrent.getX();
        this.y = positionCurrent.getY();
        pacman = new Circle();
        pacman.setFill(Color.RED);
        pacman.setRadius(25);
        pacman.setCenterX(x*50 + 25);
        pacman.setCenterY(y*50 + 25);
        pane.getChildren().add(pacman);
        Rectangle circleClear = new Rectangle();
        circleClear.setWidth(50);
        circleClear.setHeight(50);
        circleClear.setStroke(Color.BLACK);
        circleClear.setFill(Color.WHITE);
        circleClear.setX(pos.getX()*50);
        circleClear.setY(pos.getY()*50);
        pane.getChildren().add(circleClear);
        pos = new Position(this.x, this.y);
    }


    public int getUnit() {
        return 50;
    }

}
