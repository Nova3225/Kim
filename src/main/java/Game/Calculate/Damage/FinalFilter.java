package Game.Calculate.Damage;

import Game.Calculate.Filter;
import Game.Calculate.FilterChain;

public class FinalFilter implements Filter<DamageData> {
    @Override
    public DamageData doFilter(DamageData data, FilterChain<DamageData> chain) {
        data.getDefender().setHealth(data.getDefender().getHealth() - data.getFinalDamage());
        return chain.doFilter(data);
    }
}
