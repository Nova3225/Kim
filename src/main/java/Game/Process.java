package Game;

import java.util.ArrayList;

import Entity.Monster.Monster;
import Entity.Player.Player;
import Game.Levels.*;
import Game.Display.Frame;

public class Process {

    public static Player player;

    protected static Map map;

    Frame frame;

    public Process() {}

    public void init() {

        frame = new Frame();

        //display
        frame.init();

        //map&level
        map = new Map();
        map.generate();

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

    // 除了测试，一般不使用
    public static void intoRoom(LevelData levelData){

    }
}
