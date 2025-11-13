package Game.Calculate.Damage;

import Game.Calculate.Filter;
import Game.Calculate.FilterChain;

public class NormalDamageFilter implements Filter<DamageData> {

    @Override
    public DamageData doFilter(DamageData data, FilterChain<DamageData> chain) {
        return chain.doFilter(data);
    }

}
