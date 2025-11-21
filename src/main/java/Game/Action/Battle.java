package Game.Action;

import Entity.Entity;
import Entity.Monster.Monster;
import Entity.Player.Player;
import Game.Calculate.Damage.DamageCalculator;
import Game.GameProcess;
import Game.Levels.OnTheWay;

public class Battle {

    public int killedMonsterNum = 0;

    public Battle(){

    }

    public void indicate(Monster beAttacked, int damage){
        if (beAttacked.getHealth() <= 0){
            win();
        }
    }

    public void indicate(Player beAttacked, int damage){
        if (beAttacked.getHealth() <= 0){
            lose();
        }
    }

    //DISPLAY
    public void showInfo(){
        GameProcess.frame.showInfo();
    }

    //DISPLAY
    public void playerAttack(Monster monster){
        DamageCalculator damageCalculator = new DamageCalculator();
        int damage = damageCalculator.calculate(GameProcess.player, monster);
        indicate(monster, damage);
        monsterBehavior(monster);
    }

    //DISPLAY
    public void monsterBehavior(Monster monster){
        monsterAttack(monster);
    }

    public void monsterAttack(Monster monster){
        DamageCalculator damageCalculator = new DamageCalculator();
        int damage = damageCalculator.calculate(monster,GameProcess.player);
        indicate(GameProcess.player, damage);
    }

    public void win(){
        killedMonsterNum++;
        GameProcess.map.levelDatas[GameProcess.levelNum].monsters.remove(0);
        if (GameProcess.map.levelDatas[GameProcess.levelNum].monsters.size() == 0){
            OnTheWay.battleEnd();
        }
    }

    public void lose(){
        System.out.println("你输了");
        System.exit(0);
    }

}
