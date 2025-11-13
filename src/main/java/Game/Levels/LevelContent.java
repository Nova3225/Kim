package Game.Levels;


public class LevelContent {

    public LevelData levelData;


    public LevelData levelSelector(LevelData levelData){

        switch (levelData.levelType) {
            case FIGHT:
                return fight(levelData);
            default:
                return levelData;
        }
    }

    private LevelData fight(LevelData levelData){



        levelData.levelInit();
        return levelData;
    }

}
