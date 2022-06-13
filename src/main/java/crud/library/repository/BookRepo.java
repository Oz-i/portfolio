package crud.library.repository;

import crud.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Override
    List<Book> findAll();
    @Override
    Book save(Book book);
    @Override
    Optional<Book> findById(Long id);
    @Override
    void deleteById(Long id);
    @Override
    void deleteAll();
    @Query(nativeQuery = true)
    List<Book> getBooksByTitle(@Param("TITLE") String title);
    @Override
    long count();
    Boolean existsByAuthorAndTitleAndYearOfPublication(String author, String title, Integer yearOfPublication);
}
