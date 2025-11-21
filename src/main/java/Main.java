import Game.GameProcess;

public class Main {

    public static void main(String[] args) {

        GameProcess process = new GameProcess();

        process.init();
        process.goOnce();
        //process.start();

        process.quit();
    }
}
