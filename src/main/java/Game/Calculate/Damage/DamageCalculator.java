package Game.Calculate.Damage;

import Entity.Entity;
import Game.Calculate.FilterChain;

public class DamageCalculator {

    /*
    * 默认伤害过滤器链
    * DefenseFilter必须放最后 #后续用注解解决
     */
    FilterChain<DamageData> chain = new DefaultDamageFilterChain<DamageData>()
            .addFilter(new NormalDamageFilter())
            .addFilter(new RuneFilter())
            .addFilter(new DefenseFilter())
            .addFilter(new FinalFilter());

    public int calculate(Entity attacker, Entity defender) {
        DamageData data = new DamageData(attacker, defender);
        data = chain.doFilter(data);
        return data.getFinalDamage();
    }

}
