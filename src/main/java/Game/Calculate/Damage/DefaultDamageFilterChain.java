package Game.Calculate.Damage;

import Game.Calculate.Filter;
import Game.Calculate.FilterChain;

import java.util.ArrayList;

public class DefaultDamageFilterChain<T> implements FilterChain<T> {

    ArrayList<Filter<T>> filters = new ArrayList<>();
    protected int position = 0;

    public DefaultDamageFilterChain<T> addFilter (Filter<T> filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public T doFilter(T data) {
        if (position < filters.size()) {
            return filters.get(position++).doFilter(data, this);
        }
        return data;
    }

}
