package net.skillfactory.model;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> booksList;
    private BookAlarm alarm;

    public Library(){
        booksList = new ArrayList<>();
        alarm = new BookAlarm();
    }

    public void returnBook(Book book){

        if (book.getState() == BookState.Bad){
            alarm.notifyObservers();
        } else {
            booksList.add(book);
        }
    }

    public BookAlarm getAlarm() {
        return alarm;
    }
}
