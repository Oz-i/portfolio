package crud.library.exception;

import crud.library.exception.enumException.BookMessageEnumException;
public class BookAlreadyException extends RuntimeException{
    public BookAlreadyException() {
        super(BookMessageEnumException.BOOK_ALREADY_EXIST.getMessage());
    }
}
