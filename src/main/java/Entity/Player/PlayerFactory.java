package Entity.Player;

public class PlayerFactory {

    public static Player createPlayer(int health, int defense, int attack) {
        return new Player(health, defense, attack);
    }

}
