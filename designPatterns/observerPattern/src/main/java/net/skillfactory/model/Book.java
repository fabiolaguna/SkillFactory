package net.skillfactory.model;

public class Book {

    private String name;
    private BookState state;

    public Book(String name, BookState state) {
        this.name = name;
        this.state = state;
    }

    public BookState getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(BookState state) {
        this.state = state;
    }
}
