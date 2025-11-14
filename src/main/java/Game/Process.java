package Game;

import java.util.ArrayList;

import Entity.Monster.Monster;
import Entity.Player.Player;
import Game.Levels.*;
import Game.Display.Frame;

public class Process {

    public static Player player;

    protected static Map map;

    Frame frame = new Frame();

    public Process() {
    }

    public void init() {

        frame.init();
        frame.gamePanel.createPlayer();

        map = new Map();
        map.generate();
    }

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
