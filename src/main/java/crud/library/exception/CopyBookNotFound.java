package crud.library.exception;

import crud.library.exception.enumException.CopyMessageEnumException;

public class CopyBookNotFound extends RuntimeException{
    public CopyBookNotFound() {
        super(CopyMessageEnumException.BOOK_COPY_NOT_FOUND.getMessage());
    }
}
