package Game.Calculate;

public interface FilterChain<T> {

    T doFilter(T data);

}
