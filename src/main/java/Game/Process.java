package Game;

import Entity.Player.Player;
import Game.Levels.*;

public class Process {

    public static Player player;

    protected static Map map;

    public Process() {}

    public void init() {

        //map&level
        map = new Map();
        map.generate();
        map.print();

    }

    //开始游戏进程
    public void start() {
        for (LevelData levelData : map.levelDatas){
            levelData.importPlayer(levelData.player);
            levelData = map.levelManager.levelStart(levelData);
            if (levelData.player.getHealth() <= 0){
                System.out.println("游戏结束");
                return;
            }
        }
    }

}
