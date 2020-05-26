package net.skillfactory;

import net.skillfactory.model.Administration;
import net.skillfactory.model.Book;
import net.skillfactory.model.BookState;
import net.skillfactory.model.Library;
import net.skillfactory.model.Sales;
import net.skillfactory.model.Stock;

public class App {

    public static void main( String[] args ) {

        Library library = new Library();

        library.getAlarm().attach(new Administration());
        library.getAlarm().attach(new Sales());
        library.getAlarm().attach(new Stock());

        Book badStateBook = new Book("Harry Potter and the chambers of secrets", BookState.Bad);

        library.returnBook(badStateBook);
    }
}
