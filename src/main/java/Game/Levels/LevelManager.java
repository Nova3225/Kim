package Game.Levels;

import Game.GameProcess;

//连接关卡和显示器
public class LevelManager {

    public int healthRecover = 10;

    public void levelStart(LevelData levelData){
        switch (levelData.levelType) {
            case FIGHT:
                fight(levelData);
                break;
            case EVENT:
                event(levelData);
                break;
            case BOSS:
                boss(levelData);
                break;
        }
    }

    private void fight(LevelData levelData){
        GameProcess.frame.fight();
    }

    private void event(LevelData levelData) {

        //TODO

    }

    private void boss(LevelData levelData) {

        //TODO

    }



}
