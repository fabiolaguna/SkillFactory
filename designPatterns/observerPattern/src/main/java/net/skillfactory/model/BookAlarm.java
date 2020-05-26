package net.skillfactory.model;

import net.skillfactory.interfaces.IBadStateBook;
import net.skillfactory.interfaces.ISubject;

import java.util.ArrayList;
import java.util.List;

public class BookAlarm implements ISubject {

    private List<IBadStateBook> observers;

    public BookAlarm(){
        observers = new ArrayList<>();
    }

    @Override
    public void attach(IBadStateBook observer) {
        observers.add(observer);
    }

    @Override
    public void dettach(IBadStateBook observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IBadStateBook observer : observers){
            observer.update();
        }
    }
}
