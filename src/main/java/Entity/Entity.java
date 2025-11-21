package Entity;

import Game.Calculate.Damage.DamageCalculator;

public abstract class Entity {

    protected int health;
    protected int maxHealth;
    protected int defense;
    protected int attack;

    public Entity(int health, int defense, int attack) {
        this.health = health;
        this.maxHealth = health;
        this.defense = defense;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealth(int health) { //取值[0,maxHealth]
        if (health > maxHealth) {
            this.health = maxHealth;
        } else this.health = Math.max(health, 0);
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setDefense(int defense) { //取值[0,#)
        this.defense = Math.max(defense, 0);
    }

    public void setAttack(int attack) { //取值[0,#)
        this.attack = Math.max(attack, 0);
    }

    public int attack(Entity enemy) {
        DamageCalculator calculator = new DamageCalculator();
        int damage = calculator.calculate(this, enemy);
        return damage;
    }

}
