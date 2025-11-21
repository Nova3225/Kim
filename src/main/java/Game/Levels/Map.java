package Game.Levels;

public class Map {

    final int levelWidth = 1;

    public LevelData[] levelDatas = new LevelData[levelWidth];
    LevelDataGenerator levelDataGenerator = new LevelDataGenerator();
    public LevelManager levelManager = new LevelManager();

    public Map(){
        levelDatas = new LevelData[levelWidth];
    }

    public void generate(){
        for (int i = 0; i < levelWidth; i++) {
            LevelData levelData = new LevelData();
            levelData = levelDataGenerator.generate(i);
            levelDatas[i] = levelData;
        }
    }

}
