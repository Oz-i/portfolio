package crud.library.controller;

import crud.library.domain.Borrowed;
import crud.library.domain.dto.BorrowedDto;
import crud.library.exception.CopyAlreadyBorrowedException;
import crud.library.mapper.BorrowedMapper;
import crud.library.service.BorrowedRepoService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/borrow")
@AllArgsConstructor
public class BorrowController {
    private final BorrowedRepoService borrowedRepoService;
    private final BorrowedMapper borrowedMapper;

    @GetMapping()
    public List<Borrowed> getAll(){
        return borrowedRepoService.findAllBorrows();
    }
    @PostMapping(value = "saveBorrow",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveNewBorrow(@RequestBody @Valid BorrowedDto borrowedDto) throws CopyAlreadyBorrowedException {
         borrowedRepoService.saveBorrow(borrowedMapper.mapToBorrow(borrowedDto));
    }
    @GetMapping("id/{id}")
    public Borrowed getBorrowById(@PathVariable long id){
        return borrowedRepoService.findBorrowById(id);
    }
    @PutMapping("{id}")
    public Borrowed returnBook(@PathVariable long id) {
       return borrowedRepoService.setBorrowsFlagAsReturned(id);
    }
    @DeleteMapping("delete/{id}")
    public void deleteBorrow(@PathVariable long id){
        borrowedRepoService.deleteBorrowById(id);
    }
}
