package crud.library.mapper;

import crud.library.domain.Copy;
import crud.library.domain.dto.CopyDto;
import crud.library.service.BookRepoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CopyMapper {
    private final BookRepoService bookRepoService;

    public Copy mapToCopy(final CopyDto copyDto) {
        return Copy.builder()
                .id(copyDto.getId())
                .book(bookRepoService.getBookById(copyDto.getBookId()))
                .status(copyDto.getStatus())
                .canBeBorrow(copyDto.isCanBeBorrow())
                .borrowsList(copyDto.getBorrowsList())
                .build();
    }
    public CopyDto mapToCopyDTO(final Copy copy) {
        return CopyDto.builder()
                .id(copy.getId())
                .book(bookRepoService.getBookById(copy.getBook().getId()))
                .status(copy.getStatus())
                .canBeBorrow(copy.isCanBeBorrow())
                .borrowsList(copy.getBorrowsList())
                .build();
    }
    public List<CopyDto> mapToListCopyDTO(final List<Copy> copyList){
        return copyList.stream()
                .map(this::mapToCopyDTO)
                .collect(Collectors.toList());
    }
}
