package crud.library.exception;

import crud.library.exception.enumException.BookMessageEnumException;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super(BookMessageEnumException.BOOK_NOT_FOUND.getMessage());
    }
}
