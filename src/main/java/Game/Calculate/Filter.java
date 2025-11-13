package Game.Calculate;

public interface Filter<T>  {

    T doFilter(T data, FilterChain<T> chain);

}
