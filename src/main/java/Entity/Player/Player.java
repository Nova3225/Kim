package Entity.Player;

import Entity.Entity;

public class Player extends Entity {

    public XpSystem xpSystem = new XpSystem();
    protected RuneSystem runeSystem = new RuneSystem();

    public Player(int health, int defense, int attack) {
        super(health, defense, attack);
    }

}
