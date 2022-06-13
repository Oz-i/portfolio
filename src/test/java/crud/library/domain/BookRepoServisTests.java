//package crud.library.domain;
//
//import crud.library.service.BookRepoServis;
//import org.assertj.core.api.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class BookRepoServisTests {
//    @Autowired
//    private BookRepoServis bookRepoServis;
//
//    @Test
//    void addBook(){
//        Book book = new Book();
//        book.toBuilder()
//                .author("ja")
//                .title("znany")
//                .yearOfPublication(2000)
//                .build();
//        bookRepoServis.saveBook(book);
//
//        var a = bookRepoServis.findTitle("znany");
//        assertEquals(1,a.size());
//    }
//}
