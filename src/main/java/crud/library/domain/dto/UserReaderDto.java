package crud.library.domain.dto;

import crud.library.domain.Borrowed;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class UserReaderDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfCardInsertion;
    private List<Borrowed> borrowed;
}
