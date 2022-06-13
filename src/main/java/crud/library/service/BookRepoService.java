package crud.library.service;

import crud.library.domain.Book;
import crud.library.exception.BookAlreadyException;
import crud.library.exception.BookNotFoundException;
import crud.library.exception.NoTitle;
import crud.library.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookRepoService {
    private final BookRepo bookRepo;
    public List<Book> findAllBooks(){
        if (bookRepo.findAll().isEmpty())
            throw new BookNotFoundException();
        return bookRepo.findAll();
    }
    public Book getBookById(Long id) throws BookNotFoundException{
        return bookRepo.findById(id).orElseThrow(BookNotFoundException::new);
    }
    public List<Book> findTitle(final String title){
        return Optional.ofNullable(bookRepo.getBooksByTitle(title)).orElseThrow(() -> new NoTitle("wrong title "+ title));
    }
    @Transactional
    public void saveBook(final Book book)throws BookAlreadyException {
        if (bookRepo.existsByAuthorAndTitleAndYearOfPublication(
                book.getAuthor(), book.getTitle(), book.getYearOfPublication()
        )){ throw new BookAlreadyException();}
        bookRepo.save(book);
    }
    public void deleteAll(){
            bookRepo.deleteAll();
    }

    public void deleteBook(final Long id)throws BookNotFoundException{
       if(bookRepo.findById(id).isPresent()) {
           bookRepo.deleteById(id);
       }else {throw new BookNotFoundException();
       }
    }
    long countBook(){
       return bookRepo.count();
    }
}
