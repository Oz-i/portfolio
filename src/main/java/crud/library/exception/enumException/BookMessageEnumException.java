package crud.library.exception.enumException;

public enum BookMessageEnumException {
    BOOK_ALREADY_EXIST("book already exist"),
    BOOK_NOT_FOUND("wrong title or book does not exist"),
    BOOK_STATUS_NOT_FOUND("wrong book status");

    private final String message;

    BookMessageEnumException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
