package crud.library.exception;

import crud.library.exception.enumException.BorrowMessageEnumException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BorrowNotFoundException extends RuntimeException{
    public BorrowNotFoundException() {
        super(BorrowMessageEnumException.WE_HAVE_NOT_BORROW.getMessage());
    }
}
