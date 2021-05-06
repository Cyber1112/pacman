package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        File source = new File("map1.txt");
        Scanner readFile = new Scanner(source);
        Player player = new Pacman();
        Game game = null;
        Map map = null;
        map = new Map(readFile);
        Food food = new Food(map, player);
        game = new Game(map, food);
        game.addPlayer(player);
        Scene scene = new Scene(map.getMap());
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(ActionE -> {
            switch (ActionE.getCode()) {
                case W:
                    player.moveUp();
                    break;
                case S:
                    player.moveDown();
                    break;
                case D:
                    player.moveRight();
                    break;
                case A:
                    player.moveLeft();
                    break;
            }
        });
    }
}
