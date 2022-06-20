package crud.library.book;

import crud.library.domain.Book;
import crud.library.repository.BookRepo;
import crud.library.service.BookRepoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        bookList.add(Book.builder().id(2l).title("a2").author("zacny").yearOfPublication(2000).build());

        when(bookRepo.findAll()).thenReturn(bookList);
        var result = service.findAllBooks();
        assertThat(result).hasSize(2);
    }
    @Test
    void shouldGetBookById(){
        var book = TestBookBuilder.newBook().build();
        when(bookRepo.findById(anyLong())).thenReturn(Optional.ofNullable(book));
         var result = service.getBookById(anyLong());
        assertEquals(result.getTitle(),book.getTitle());
    }
}
