package Game;

import Entity.Player.Player;
import Game.Levels.*;
import Display.Frame;

public class Process {

    public static Player player;

    protected static Map map;

    public static Frame frame;

    public Process() {

    }

    public void init() {

        //地图生成
        map = new Map(); //ArrayList<LevelData>:levelDatas;
        map.generate();
        //map.print();

        //显示系统初始化
        frame = new Frame();

    }

    public void quit(){

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
