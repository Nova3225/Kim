package Game.Levels;

import Entity.Monster.Monster;

import java.util.ArrayList;
import java.util.Random;

public class LevelDataGenerator {

    final int RANDOMED_LEVEL_TYPE_COUNT = 2;

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
        /*

        int levelType = random.nextInt(0,RANDOMED_LEVEL_TYPE_COUNT);
        if(levelType == 0){
            levelData = new LevelData();
            levelData.setLevelData(LEVEL_TYPE.FIGHT, new ArrayList<Monster>(){
                {
                    add(new Monster(800, 0, 100));
                }
            });
            return levelData;
        } else if (levelType == 1){
            levelData = new LevelData();
            levelData.setLevelData(LEVEL_TYPE.EVENT, null);
            return levelData;
        }
        return null;

         */
    }

}
