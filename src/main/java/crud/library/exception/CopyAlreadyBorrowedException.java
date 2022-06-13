package crud.library.exception;

import crud.library.exception.enumException.CopyMessageEnumException;

public class CopyAlreadyBorrowedException extends Throwable {
    public CopyAlreadyBorrowedException() {
        super(CopyMessageEnumException.BOOK_COPY_ALREADY_BORROWED.getMessage());
    }
}
