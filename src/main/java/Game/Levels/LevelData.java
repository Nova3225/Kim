package Game.Levels;

import java.util.ArrayList;

import Entity.Monster.Monster;
import Entity.Player.Player;


//事先生成好关卡数据，玩家到达时导入玩家数据
public class LevelData {

    //Presets
    public LEVEL_TYPE levelType;
    public ArrayList<Monster> monsters = new ArrayList<>();

    //Import when level starts
    public Player player;

    public LevelData(){}

    //Import presets
    public void setLevelData(LEVEL_TYPE levelType, ArrayList<Monster> monsters){
        this.levelType = levelType;
        this.monsters = monsters;
    }

    //Import other when level starts
    public void importPlayer(Player player){
        this.player = player;
    }


}