package Game;

import Entity.Player.Player;
import Game.Levels.*;
import Display.Frame;

public class GameProcess {

    public static Player player;

    public static Map map;

    public static Frame frame;

    public GameProcess() {

    }

    public void init() {

        //玩家信息生成
        player = new Player(1200, 50, 100);

        //地图生成
        map = new Map(); //ArrayList<LevelData>:levelDatas;
        map.generate();
        //map.print();



    }

    public void showFrame(){

        //显示系统初始化
        frame = new Frame();

    }

    public void quit(){

    }

    //开始游戏进程
    public void go() {

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
