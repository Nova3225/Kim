package Game.Levels;

import java.util.ArrayList;

import Entity.Monster.Monster;
import Entity.Player.Player;
import Game.Process;

public class LevelData {

    public LEVEL_TYPE levelType;
    public ArrayList<Monster> monsters = new ArrayList<>();

    public LevelData(LEVEL_TYPE levelType){
        this.levelType = levelType;
    }

    public void levelInit(){
        Process.player.setDefense(0);
    }

}