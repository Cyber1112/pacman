package sample;

import static java.util.Arrays.fill;

public class Pacman extends MyPlayer{
    private int[] moveDir = {0, 0, 0, 1};
    public Pacman(){ }
    private void defaultArr(){
        fill(moveDir, 0);
    }
    public void moveRight() {
        if(moveDir[0] == 1){
            super.moveRight();
        }
        else{
            defaultArr();
            moveDir[0] = 1;
        }
    }
    public void moveLeft() {
        if(moveDir[1] == 1){
            super.moveLeft();
        }
        else{
            defaultArr();
            moveDir[1] = 1;
        }
    }
    public void moveDown() {
        if(moveDir[2] == 1){
            super.moveDown();
        }
        else{
            defaultArr();
            moveDir[2] = 1;
        }

    }

    public void moveUp() {
        if(moveDir[3] == 1){
            super.moveUp();
        }
        else{
            defaultArr();
            moveDir[3] = 1;
        }
    }
}
