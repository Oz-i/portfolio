package crud.library.repository;

import crud.library.domain.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface CopyRepo extends JpaRepository<Copy, Long> {
    Long countBookCopiesByBookIdAndCanBeBorrowIsTrue(long id);
    @Override
    List<Copy> findAll();

    Copy save(Copy copy);
    @Override
    Optional<Copy> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();

    @Query(nativeQuery = true)
    List<Copy> getCopiesByStatus(@Param("STATUS") String status);
}
