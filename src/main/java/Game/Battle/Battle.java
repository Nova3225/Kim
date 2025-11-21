package Game.Battle;

import Entity.Monster.Monster;
import Game.Calculate.Damage.DamageCalculator;
import Game.GameProcess;

public class Battle {

    public void Battle(){

    }

    //DISPLAY
    public void playerAttack(Monster monster){
        DamageCalculator damageCalculator = new DamageCalculator();
        int damage = damageCalculator.calculate(GameProcess.player, monster);
        System.out.println(damage);

        monsterBehavior();
    }

    //DISPLAY
    public void monsterBehavior(){

    }

}
