package crud.library.domain.dto;

import crud.library.domain.Copy;
import crud.library.domain.UserReader;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class BorrowedDto {
    private Long id;
    private Copy copy;
    private UserReader reader;
    private Long id_copy;
    private Long id_reader;
    private boolean returned;
    private LocalDate loanOfDate;
    private LocalDate returnOfDate;
}
