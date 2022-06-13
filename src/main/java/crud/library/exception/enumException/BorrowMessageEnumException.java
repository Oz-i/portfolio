package crud.library.exception.enumException;

public enum BorrowMessageEnumException {
    WE_HAVE_NOT_BORROW("wrong borrow id or borrow not exist");

    private final String message;

    BorrowMessageEnumException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
