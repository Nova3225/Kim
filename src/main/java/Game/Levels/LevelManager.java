package Game.Levels;

public class LevelManager {

    public int healthRecover = 10;

    public LevelData levelStart(LevelData levelData){
        switch (levelData.levelType) {
            case FIGHT:
                return fight(levelData);
            case EVENT:
                return event(levelData);
            case BOSS:
                return boss(levelData);
            default:
                return levelData;
        }
    }



    private LevelData fight(LevelData levelData){

        //TODO

        levelData.player.setHealth(levelData.player.getHealth() + healthRecover);
        // 返回修改后的levelData以便分析战后数据
        return levelData;
    }

    private LevelData event(LevelData levelData) {
        return levelData;
    }

    private LevelData boss(LevelData levelData) {
        return levelData;
    }



}
