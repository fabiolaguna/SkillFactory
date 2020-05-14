package interfaces;

@FunctionalInterface
public interface Multiplication<T extends Number, V extends Number, R extends Number> {

    R getMultiplication(T t, V v);
}
