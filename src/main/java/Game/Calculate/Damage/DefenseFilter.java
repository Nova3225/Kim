package Game.Calculate.Damage;

import Entity.Monster.Monster;
import Entity.Player.Player;
import Game.Calculate.Filter;
import Game.Calculate.FilterChain;

public class DefenseFilter implements Filter<DamageData>{

    @Override
    public DamageData doFilter(DamageData data, FilterChain<DamageData> chain) {
        int maxDamage;
        if (data.getDefender().getDefense() > 0){
            if (data.getFinalDamage() > data.getDefender().getDefense()){
                if (data.getDefender().getClass() == Player.class){
                    if (data.getDefender().getMaxHealth() >= 1000){
                        maxDamage = data.getDefender().getMaxHealth() / 2;
                    } else {
                        maxDamage = 500;
                    }
                } else if (data.getDefender().getClass() == Monster.class) {
                    if (data.getDefender().getMaxHealth() >= 900){
                        maxDamage = data.getDefender().getMaxHealth() / 10 * 9;
                    } else {
                        maxDamage = 900;
                    }
                }
            }else {
                data.getDefender().setDefense(data.getDefender().getDefense() - data.getFinalDamage());
                data.setFinalDamage(0);
            }
        }
        return chain.doFilter(data);
    }

}
