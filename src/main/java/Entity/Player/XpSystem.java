package Entity.Player;

public class XpSystem {

    protected int xp = 0;
    protected int level = 0;
    protected int xpToLevelUp = 100;
    protected final int xpGrowth = 50;

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getXpToLevelUp() {
        return xpToLevelUp;
    }

    public void addXp(int xp, Player player) {
        this.xp += xp;
        if (this.xp >= this.xpToLevelUp) {
            this.levelUp();
            this.xp = 0;
            player.setMaxHealth(player.getMaxHealth() + 100);
            player.setHealth(player.getMaxHealth());
            player.setAttack(player.getAttack() + 10);
        }
    }

    public void levelUp() {
        this.level++;
        this.xpToLevelUp += this.xpGrowth;
        this.xp = 0;
    }

}
