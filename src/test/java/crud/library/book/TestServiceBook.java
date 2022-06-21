package crud.library.book;

import crud.library.domain.Book;
import crud.library.exception.BookNotFoundException;
import crud.library.repository.BookRepo;
import crud.library.service.BookRepoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@SpringBootTest
public class TestServiceBook {
    @Autowired
    private BookRepoService service;
    @Autowired
    private BookRepo bookRepo;

    @BeforeEach
    void beforeAll() {
        bookRepo = mock(BookRepo.class);
        service = new BookRepoService(bookRepo);
    }
    @Test
    void shouldGetAllBook(){
        List<Book>bookList = new ArrayList<>();
        bookList.add(Book.builder().id(1L).title("a1").author("znany").yearOfPublication(1000).build());
        bookList.add(Book.builder().id(2L).title("a2").author("zacny").yearOfPublication(2000).build());

        when(bookRepo.findAll()).thenReturn(bookList);
        var result = service.findAllBooks();
        assertThat(result).hasSize(2);
    }
    @Test
    void shouldGetBookById(){
        var book = Book.builder().build();
        when(bookRepo.findById(anyLong())).thenReturn(Optional.ofNullable(book));
         var result = service.getBookById(anyLong());
        if (book != null) {
            Assertions.assertEquals(result.getTitle(), book.getTitle());
        }
    }
    @Test
    void shouldGetBooksByTitle(){
       List<Book>bookList = new ArrayList<>();
       bookList.add(Book.builder().build());
       when(bookRepo.getBooksByTitle(anyString())).thenReturn(bookList);
       var result = service.findTitle("test");
       assertThat(result).isEqualTo(bookList);
       assertThat(result).hasSize(1);
    }
    @Test
    void shouldReturnException(){
        when(bookRepo.findById(anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(BookNotFoundException.class,() -> service.getBookById(anyLong()));
    }
    @Test
    void shouldAddBook(){
        var book = Book.builder().id(1L).title("t").build();
        when(bookRepo.save(book)).thenReturn(book);
        var result = service.saveBook(book);
        assertThat(result.getTitle()).isEqualTo(book.getTitle());
        assertThat(result.getId()).isEqualTo(book.getId());
    }
}
