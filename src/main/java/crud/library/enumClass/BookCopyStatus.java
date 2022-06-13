package crud.library.enumClass;

public enum BookCopyStatus {
    IN_USE("IN USE"),
    IN_RENOVATION("IN RENOVATION"),
    LOST("LOST"),
    DESTROYED("DESTROYED");

    private final String description;

    BookCopyStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
