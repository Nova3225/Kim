import Game.GameProcess;

public class Main {

    public static void main(String[] args) {

        GameProcess process = new GameProcess();

        process.init();

        process.frame.start();

        //process.start();

        process.quit();
    }
}
