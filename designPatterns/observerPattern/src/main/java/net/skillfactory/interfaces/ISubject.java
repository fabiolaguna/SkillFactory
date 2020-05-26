package net.skillfactory.interfaces;

public interface ISubject {

    void attach(IBadStateBook observer);
    void dettach(IBadStateBook observer);
    void notifyObservers();
}
