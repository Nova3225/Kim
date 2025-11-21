package Game.Calculate.Damage;

import Entity.Monster.Monster;
import Entity.Player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DamageCalculatorTest {

    @Test
    public void testCalculateDamage() {
        // TODO: Implement test logic
        DamageCalculator damageCalculator = new DamageCalculator();
        Player player = new Player(1000, 100, 100);
        Monster monster = new Monster(1000, 100, 100);
        Assertions.assertEquals(damageCalculator.calculate(player, monster), 0);

    }

}
