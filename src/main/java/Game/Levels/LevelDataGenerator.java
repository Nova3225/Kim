package Game.Levels;

import Entity.Monster.Monster;

import java.util.ArrayList;
import java.util.Random;

public class LevelDataGenerator {

    Random random = new Random();

    public void levelDataGenerator(){

    }

    // 生成关卡 #不完善
    public LevelData generate(int levelNum){
        LevelData levelData;
        // 决定关卡类型

        levelData = new LevelData();
        levelData.setLevelData(LEVEL_TYPE.FIGHT, new ArrayList<Monster>(){
            {
                add(new Monster(800, 50, 100));
            }
        });
        return levelData;
    }

}
