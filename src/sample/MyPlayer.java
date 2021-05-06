package sample;

public class MyPlayer implements Player{
    Map map;
    Position position = new Position();
    @Override
    public void setMap(Map map){
        this.map = map;
    }
    @Override
    public void moveUp(){
        if(position.getY() == 0){

        }else if(map.getValueAt(position.getX(), position.getY() - 1) != '1'){
            position.setY(getPosition().getY() - 1);
            this.map.setPositionPacman(getPosition());
        }
    }
    @Override
    public void moveLeft(){
        if(position.getX() == 0){

        }else if(map.getValueAt(position.getX() - 1, position.getY()) != '1'){
            position.setX(getPosition().getX() - 1);
            this.map.setPositionPacman(getPosition());
        }
    }
    @Override
    public void moveRight(){
        if(position.getX() == map.getSize() - 1){

        }else if(map.getValueAt(position.getX() + 1, position.getY()) != '1'){
            position.setX(getPosition().getX() + 1);
            this.map.setPositionPacman(getPosition());
        }
    }
    @Override
    public void moveDown(){
        if(position.getY() == map.getSize() - 1){

        }else if(map.getValueAt(position.getX(), position.getY() + 1) != '1'){
            position.setY(getPosition().getY() + 1);
            this.map.setPositionPacman(getPosition());
        }
    }
    @Override
    public Position getPosition(){
        return position;
    }

}
