package crud.library.repository;

import crud.library.domain.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowedRepo extends JpaRepository<Borrowed, Long> {
    @Override
    List<Borrowed> findAll();
    @Override
    Borrowed save(Borrowed borrowed);
    @Override
    Optional<Borrowed> findById(Long id);
    @Override
    void deleteById(Long id);
    @Override
    long count();
}
