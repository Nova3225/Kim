package Game.Battle;

import static org.junit.jupiter.api.Assertions.*;
import Game.Battle.Battle;
import Game.GameProcess;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
        assertEquals(battle.playerAttack(gameProcess.map.levelDatas[0].monsters.get(0)), 50);
    }

}