package Game.Battle;

import Entity.Monster.Monster;
import Game.Calculate.Damage.DamageCalculator;
import Game.GameProcess;

public class Battle {

    public void Battle(){

    }

    //DISPLAY
    public int playerAttack(Monster monster){
        DamageCalculator damageCalculator = new DamageCalculator();
        int damage = damageCalculator.calculate(GameProcess.player, monster);
        System.out.println(damage);

        monsterBehavior(monster);
        return damage;
    }

    //DISPLAY
    public void monsterBehavior(Monster monster){
        monsterAttack(monster);
    }

    public void monsterAttack(Monster monster){
        DamageCalculator damageCalculator = new DamageCalculator();
        int damage = damageCalculator.calculate(monster,GameProcess.player);
        System.out.println("Monster attacking...");
        System.out.println(damage);
    }

}
