package sample;

import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

//
// Decompiled by Procyon v0.5.36
//

public class Food
{
    private Map map;
    private Pane foodPane;
    private Player player;
    private Circle circle;
    private Position foodPosition;
    private Label seconds;
    private final int timer = 5;
    private int numOfCircles;
    private int time;
    private int points;
    private int size;


    public Food(final Map map, final Player player) {
        this.numOfCircles = 10;
        this.map = map;
        this.foodPane = new Pane();
        this.map.pane.getChildren().add((Node) this.foodPane);
        this.player = player;
        this.size = this.map.getSize();
        new Thread(() -> {
            while (this.numOfCircles > 0) {
                this.createFood();
                Platform.runLater(() -> this.foodPane.getChildren().addAll(new Node[]{this.circle, this.seconds}));
                this.time = 5;
                while (this.time > 0) {
                    Platform.runLater(() -> this.seconds.setText("" + this.time));
                    if (this.player.getPosition().equals(this.foodPosition)) {
                        this.points += this.time;
                        break;
                    }
                    else {
                        try {
                            Thread.sleep(1000L);
                        }
                        catch (InterruptedException ex) {}
                        --this.time;
                    }
                }
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException ex2) {}
                Platform.runLater(() -> this.foodPane.getChildren().clear());
                --this.numOfCircles;
            }
            System.out.println(this.getPoints());
        }).start();
    }

    public int getPoints() {
        return this.points;
    }

    public Position getPosition() {
        return this.foodPosition;
    }

    private void createFood() {
        final Random random = new Random();
        Position position = new Position();
        final double n = this.map.getUnit();
        Position foodPosition;
        int nextInt;
        int nextInt2;
        do {
            nextInt2 = random.nextInt(this.size);
            nextInt = random.nextInt(this.size);
            foodPosition = new Position(nextInt2, nextInt);
        } while (this.player.getPosition().equals(foodPosition) || this.map.getValueAt(nextInt, nextInt2) != '0');
        (this.circle = new Circle(nextInt2 * n + n / 2.0, nextInt * n + n / 2.0, n / 4.0)).setFill((Paint)Color.GREEN);

        this.foodPosition = foodPosition;
        (this.seconds = new Label("5")).setTranslateX(nextInt2 * n);
        this.seconds.setTranslateY(nextInt * n);
    }
}



