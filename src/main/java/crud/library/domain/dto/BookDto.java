package crud.library.domain.dto;

import crud.library.domain.Copy;
import lombok.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private Integer yearOfPublication;
    private List<Copy> copies;
}
