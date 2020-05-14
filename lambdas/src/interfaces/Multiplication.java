package interfaces;

@FunctionalInterface
public interface Multiplication<T extends Number, V extends Number, R extends Number> {

    R mult(T t, V v);
}
