package Game.Calculate.Damage;

import Entity.Monster.Monster;
import Entity.Player.Player;
import Game.Calculate.Filter;
import Game.Calculate.FilterChain;

public class DefenseFilter implements Filter<DamageData>{

    @Override
    public DamageData doFilter(DamageData data, FilterChain<DamageData> chain) {
        int maxDamage = 999999;
        if (data.getDefender().getDefense() > 0){
            if (data.getFinalDamage() > data.getDefender().getDefense()){
                if (data.getDefender().getClass() == Player.class){
                    if (data.getDefender().getMaxHealth() >= 1000){
                        maxDamage = data.getDefender().getMaxHealth() / 2;
                    } else {
                        maxDamage = 500;
                    }
                }
                if (data.getFinalDamage() - data.getDefender().getDefense() <= maxDamage){
                    data.setFinalDamage(data.getFinalDamage() - data.getDefender().getDefense());
                }else{
                    data.setFinalDamage(maxDamage);
                    System.out.println("本次攻击伤害有封顶！为：" + maxDamage);
                }
                data.getDefender().setDefense(0);
            }else {
                data.getDefender().setDefense(data.getDefender().getDefense() - data.getFinalDamage());
                data.setFinalDamage(0);
            }
        }
        return chain.doFilter(data);
    }

}
