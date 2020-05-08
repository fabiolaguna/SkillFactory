package net.skillfactory;

import java.util.LinkedList;

public class Stack<T extends Comparable> {

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

    public T getMax(){

        T max = this.getTop();
        for(T t : list){
            if(max.compareTo(t) < 0)
                max = t;
        }

        return max;
    }
    public T getMin(){

        T min = this.getTop();
        for(T t : list){
            if(min.compareTo(t) > 0)
                min = t;
        }

        return min;
    }
}
