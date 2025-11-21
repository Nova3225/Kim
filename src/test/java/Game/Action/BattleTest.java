package Game.Action;

import static org.junit.jupiter.api.Assertions.*;

import Game.GameProcess;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BattleTest {

    static GameProcess gameProcess;

    @BeforeAll
    static void setUpBeforeClass(){
        gameProcess = new GameProcess();
        gameProcess.init();
    }

    @Test
    public void testBattle() {
        Battle battle = new Battle();
    }

}