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

    }

    // 除了测试，一般不使用
    public static void intoRoom(LevelData levelData){

    }



}
