package sample;

public class Game {
    private int x;
    private int y;
    Map map;
    Player player;
    Food food;
    public Game(Map map, Food food){
        this.map = map;
        this.food = food;
    }
    public void setMap(Map map){
        this.map=map;
    }
    public void addPlayer(Player player){
        this.player = player;
        this.player.setMap(map);
    }

}
