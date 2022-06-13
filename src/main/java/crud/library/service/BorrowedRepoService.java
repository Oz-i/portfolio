package crud.library.service;

import crud.library.domain.Borrowed;
import crud.library.domain.Copy;
import crud.library.exception.BorrowNotFoundException;
import crud.library.exception.CopyAlreadyBorrowedException;
import crud.library.repository.BorrowedRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BorrowedRepoService {
    private final BorrowedRepo borrowedRepo;
    private final CopyRepoService copyRepoService;

    public List<Borrowed> findAllBorrows(){
        return borrowedRepo.findAll();
    }
    public Borrowed findBorrowById(long id) {
        var a = borrowedRepo.findById(id).orElseThrow(BorrowNotFoundException::new).isReturned();
        if (!a){
            borrowedRepo.findById(id);
        }
        return borrowedRepo.findById(id).orElseThrow();
    }
    public boolean isReadyToBorrow(Copy copy){return !copy.isCanBeBorrow();}
    @Transactional
    public Borrowed saveBorrow(final Borrowed borrowed) throws CopyAlreadyBorrowedException {
        Copy copy = borrowed.getCopy();
        if (isReadyToBorrow(copy)){
            throw new CopyAlreadyBorrowedException();
        }
        copy.setCanBeBorrow(false);
        copyRepoService.saveCopy(copy);
        return borrowedRepo.save(borrowed);
    }
    @Transactional
    public Borrowed setBorrowsFlagAsReturned(long id){
        Borrowed borrowed = borrowedRepo.findById(id).orElseThrow(BorrowNotFoundException::new);
        borrowed.setReturned(true);
        borrowedRepo.save(borrowed);
        Copy copy = copyRepoService.getBookCopyByIp(borrowed.getCopy().getId());
        copyRepoService.setCopyStatusAsReturned(copy.getId());
        return borrowedRepo.save(borrowed);
    }
    public void deleteBorrowById(long id){
        Borrowed borrowed = borrowedRepo.findById(id).orElseThrow(BorrowNotFoundException::new);
        Copy copy = borrowed.getCopy();

        copy.getBorrowsList().remove(borrowed);
        borrowedRepo.delete(borrowed);
    }
}
