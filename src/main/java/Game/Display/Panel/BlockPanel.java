package Game.Display.Panel;

public class BlockPanel extends Panel {

    public BlockPanel(){
        super();
        importPhotos();

        //测试
        fightingArrangement();
    }

    protected void importPhotos(){
        importComponentD("Background","/Background/Background.png");
        importComponentD("PlayerDataPanel","/Panels/DataFrame.png");
        importComponentD("MonsterDataPanel","/Panels/MonsterDataFrame.png");
    }

    @Override
    public void fightingArrangement () {
        find("Background").setAttribute(0, 0, WIDTH, HEIGHT);
        find("PlayerDataPanel").setAttribute(0, 0, WIDTH / 3, HEIGHT);
        find("MonsterDataPanel").setAttribute(WIDTH / 3 * 2, 0, WIDTH / 3, HEIGHT);
    }

}