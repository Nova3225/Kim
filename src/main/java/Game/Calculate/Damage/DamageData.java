package Game.Calculate.Damage;

import Entity.Entity;
import Entity.Player.Player;

public class DamageData{

    private int originDamage;
    private int finalDamage;
    private Entity attacker;
    private Entity defender;

    public DamageData(Entity attacker, Entity defender) {
        originDamage = attacker.getAttack();
        this.attacker = attacker;
        this.defender = defender;
    }

    public int getOriginDamage() {
        return originDamage;
    }

    public int getFinalDamage() {
        return finalDamage;
    }

    public void setFinalDamage(int finalDamage) {
        this.finalDamage = finalDamage;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public Entity getDefender() {
        return defender;
    }

}
