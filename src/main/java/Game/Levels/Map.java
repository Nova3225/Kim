package Game.Levels;

public class Map {

    final int levelWidth = 4;

    public LevelData[] levelDatas = new LevelData[levelWidth];
    LevelDataGenerator levelDataGenerator = new LevelDataGenerator();

    public Map(){
        levelDatas = new LevelData[levelWidth];
    }

    public LevelManager levelManager = new LevelManager();

    public void generate(){
        for (int i = 0; i < levelWidth; i++) {
            LevelData levelData = new LevelData();
            levelData = levelDataGenerator.generate(i);
            levelDatas[i] = levelData;
        }
    }

    public void print(){
        for (int i = 0; i < levelWidth; i++) {
            System.out.println(levelDatas[i].levelType);
        }
    }


}
