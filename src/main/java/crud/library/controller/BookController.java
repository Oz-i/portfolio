package crud.library.controller;

import crud.library.domain.dto.BookDto;
import crud.library.mapper.BookMapper;
import crud.library.service.BookRepoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/book")
@AllArgsConstructor
@Slf4j
public class BookController {
    private final BookRepoService bookRepoService;
    private final BookMapper bookMapper;
    @GetMapping(value = "getAllBook")
    public List<BookDto> getAllBook(){
        return bookMapper.mapToListBookDto(bookRepoService.findAllBooks());
    }
    @GetMapping("{bookId}")
    public BookDto getOneBook(@PathVariable Long bookId){
        return bookMapper.mapToBookDto(bookRepoService.getBookById(bookId));
    }
    @GetMapping("title")
    public List<BookDto> getByTitle(@RequestParam String title){
           return bookMapper.mapToListBookDto(bookRepoService.findTitle(title));
    }
    @PostMapping(value = "addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void saveBook(@RequestBody @Valid BookDto bookDto){
        log.info("start bookMapper");
            bookRepoService.saveBook(bookMapper.mapToBook(bookDto));
    }
    @DeleteMapping("deleteAll")
    public void deleteAll(){
        bookRepoService.deleteAll();
    }
    @DeleteMapping("{id}")
    public void deleteByIp(@PathVariable Long id){
            bookRepoService.deleteBook(id);
    }
}
