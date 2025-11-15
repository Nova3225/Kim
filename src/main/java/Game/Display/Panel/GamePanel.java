package Game.Display.Panel;

import Game.Display.Component.Entity;

public class GamePanel extends Panel implements Runnable{

    // Display
    final static int FPS = 60;
    public Thread gameThread = new Thread(this);

    Entity playerEntity;

    public GamePanel(){
        super();
        importPhotos();

        //测试
        importComponentD("Player","/Player/PlayerKim.png");
        fightingArrangement();
    }

    protected void importPhotos(){

    }

    @Override
    public void fightingArrangement(){
        find("Player").setAttribute(WIDTH / 3 / 3, HEIGHT / 6 / 2, WIDTH / 3 / 3, WIDTH / 3 / 3);
    }

    @Override
    public void run() {
        //Timer
        //上一次刷新的时刻
        double lastTime = System.nanoTime();
        //每一帧的间隔时间
        final double durationTimePerFrame = (double) 1000000000 / FPS;
        //当前时刻
        double currentTime;
        //现在距离上一帧的时刻是否满一帧的时长
        double total = 0;
        //每秒帧率计数
        double framePerSecondCount = 0;
        //按秒计时
        double timer = 0;

        while (gameThread != null){
            currentTime = System.nanoTime();
            total += (currentTime - lastTime)/durationTimePerFrame;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if (total >= 1){
                lastTime = System.nanoTime();
                framePerSecondCount += 1;
                total--;
                //刷新与绘图
                refresh();
            }
            //帧率显示
            if (timer >= 1000000000) {
                System.out.println("FPS:" + framePerSecondCount);
                framePerSecondCount = 0;
                timer = 0;
            }
        }
    }


}
