package crud.library.mapper;

import crud.library.domain.Book;
import crud.library.domain.dto.BookDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto){
        return  Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .yearOfPublication(bookDto.getYearOfPublication())
                .copies(bookDto.getCopies())
                .build();
    }

    public BookDto mapToBookDto(final Book book){
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .yearOfPublication(book.getYearOfPublication())
                .copies(book.getCopies())
                .build();
    }

    public List<BookDto> mapToListBookDto(final List<Book> bookList){
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
