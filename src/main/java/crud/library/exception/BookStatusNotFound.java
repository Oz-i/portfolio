package crud.library.exception;

import crud.library.exception.enumException.BookMessageEnumException;

public class BookStatusNotFound extends RuntimeException {
    public BookStatusNotFound() {
        super(BookMessageEnumException.BOOK_STATUS_NOT_FOUND.getMessage());
    }
}
