package crud.library.book;

import crud.library.domain.Book;
import crud.library.domain.Copy;

import java.util.List;

public class TestBookBuilder {
    private Long id = 1L;
    private String title = "title 1";
    private String author = "author 1";
    private Integer yearOfPublication = 1000;

    public static TestBookBuilder newBook(){return new TestBookBuilder();}

    TestBookBuilder withId(Long id){
        this.id = id;
        return this;
    }
    TestBookBuilder withTitle(String title){
        this.title = title;
        return this;
    }
    TestBookBuilder withAuthor (String author){
        this.author = author;
        return this;
    }
    TestBookBuilder withYearPublication (Integer publication){
        this.yearOfPublication = yearOfPublication;
        return this;
    }
    public TestBookBuilder but(){
        return TestBookBuilder
                .newBook()
                .withId(id)
                .withTitle(title)
                .withAuthor(author)
                .withYearPublication(yearOfPublication);
    }
    public Book build(){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearOfPublication(yearOfPublication);
        return book;
    }
}
