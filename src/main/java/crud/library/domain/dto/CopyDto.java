package crud.library.domain.dto;

import crud.library.domain.Book;
import crud.library.domain.Borrowed;
import crud.library.enumClass.BookCopyStatus;
import lombok.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CopyDto {
    private long id;
    private long bookId;
    private BookCopyStatus status;
    private Book book;
    private boolean canBeBorrow;
    private List<Borrowed> borrowsList;
}
