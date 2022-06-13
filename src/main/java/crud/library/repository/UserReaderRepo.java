package crud.library.repository;

import crud.library.domain.UserReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserReaderRepo extends JpaRepository<UserReader, Long> {
    @Override
    List<UserReader> findAll();
    @Override
    UserReader save(UserReader userReader);
    @Override
    Optional<UserReader> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
