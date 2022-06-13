package crud.library.mapper;

import crud.library.domain.Borrowed;
import crud.library.domain.dto.BorrowedDto;
import crud.library.service.CopyRepoService;
import crud.library.service.UserReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BorrowedMapper {
    private final CopyRepoService copyRepoService;
    private final UserReaderService userReaderService;

    public Borrowed mapToBorrow(BorrowedDto borrowedDto){
        return Borrowed.builder()
                .copy(copyRepoService.getBookCopyByIp(borrowedDto.getId_copy()))
                .reader(userReaderService.getUserById(borrowedDto.getId_reader()))
                .returned(borrowedDto.isReturned())
                .loanOfDate(borrowedDto.getLoanOfDate())
                .returnOfDate(borrowedDto.getReturnOfDate())
                .build();
    }
    public BorrowedDto mapToBorrowDTO(Borrowed borrowed){
        return BorrowedDto.builder()
                .id(borrowed.getId())
                .copy(copyRepoService.getBookCopyByIp(borrowed.getId()))
                .reader(userReaderService.getUserById(borrowed.getId()))
                .returnOfDate(borrowed.getReturnOfDate())
                .loanOfDate(borrowed.getLoanOfDate())
                .returned(borrowed.isReturned())
                .build();
    }
    public List<BorrowedDto> mapToListBorrowedDto(List<Borrowed> dtos){
        return dtos.stream()
                .map(this::mapToBorrowDTO)
                .collect(Collectors.toList());
    }

}
