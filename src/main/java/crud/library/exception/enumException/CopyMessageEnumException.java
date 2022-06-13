package crud.library.exception.enumException;

public enum CopyMessageEnumException {

    BOOK_COPY_NOT_FOUND("wrong title or book does not exist"),
    BOOK_COPY_ALREADY_BORROWED("Book is borrowed");

    private final String message;

    CopyMessageEnumException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
