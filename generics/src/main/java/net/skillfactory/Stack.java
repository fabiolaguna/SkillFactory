package net.skillfactory;

import java.util.LinkedList;

public class Stack<T> {

    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T element) {
        list.push(element);
    }

    public T pop() {

        T removed = null;
        if (list.size() > 0) {
            removed = list.pop();
        }

        return removed;
    }

    public int size() {
        return list.size();
    }

    public T getTop() {

        T top = null;
        if (list.size() > 0) {
            top = list.getFirst();
        }

        return top;
    }
}
