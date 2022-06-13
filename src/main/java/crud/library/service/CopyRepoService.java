package crud.library.service;

import crud.library.domain.Copy;
import crud.library.enumClass.BookCopyStatus;
import crud.library.exception.BookStatusNotFound;
import crud.library.exception.CopyBookNotFound;
import crud.library.repository.CopyRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CopyRepoService {
    private final CopyRepo copyRepo;
    public List<Copy> findAllCopy(){
        return copyRepo.findAll();}
    @Transactional
    public Copy saveCopy(final Copy copy){
        log.info("start servis - save.1");
        return copyRepo.save(copy);
    }
    public void deleteCopyById(long id) {
        if (copyRepo.existsById(id)) {
            copyRepo.deleteById(id);
        } else throw new CopyBookNotFound();
    }
    public Copy getBookCopyByIp(final Long id){
        return copyRepo.findById(id).orElseThrow(CopyBookNotFound::new);}
    public Long countCopyCanBeBorrow(final long id){
        return copyRepo.countBookCopiesByBookIdAndCanBeBorrowIsTrue(id);}
    public List<Copy> getCopyByStatus(final String status){
        return copyRepo.getCopiesByStatus(status);}
    @Transactional
    public Copy updateCopyBookStatus(final Long id, final String status){
        Copy copy = this.getBookCopyByIp(id);
        try {
            copy.setStatus(status);
        } catch (BookStatusNotFound e) {
            throw new BookStatusNotFound();
        }
        return saveCopy(copy);
    }
    @Transactional
    public void setCopyStatusAsReturned(long id){
        Copy copy = this.getBookCopyByIp(id);
        copy.setStatus(BookCopyStatus.IN_USE.getDescription());
        saveCopy(copy);}
}
