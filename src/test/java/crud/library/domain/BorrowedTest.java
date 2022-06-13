package crud.library.domain;

import crud.library.repository.UserReaderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BorrowedTest {
    @Autowired
    UserReaderRepo userReaderRepo;

    private static final LocalDate LOCAL_DATE = LocalDate.now();
    private static final String LIST_WYP = "wypozyczone";
    private static final String LIST_BIB = "do wziecia";

    @Test
    void borrowedUserReaderTest() {
//        Borrowed borrowed = new Borrowed(LOCAL_DATE, LOCAL_DATE.plusDays(12));
//        Borrowed borrowed1 = new Borrowed(LOCAL_DATE, LOCAL_DATE.plusDays(6));
//        Copy copy = new Copy(LIST_WYP);
//        copy.setTitle(new Book("O pszczolach","Pszczelinski",2002));
//
//        Copy copy1 = new Copy(LIST_BIB);
//        copy1.setTitle(new Book("O kwiatach","Ziolko",1999));
//
//        borrowed.setCopy(copy);
//        borrowed1.setCopy(copy1);
//
//        UserReader userReader = new UserReader("Jas","kowalski",LOCAL_DATE.minusMonths(1));
//        //UserReader userReader1 = new UserReader("Krzys","Puchatek",LOCAL_DATE.plusDays(4));
//
//        userReader.getBorroweds().add(borrowed);
//        userReader.getBorroweds().add(borrowed1);
//        borrowed.setReader(userReader);
//        borrowed1.setReader(userReader);
//
//        userReaderRepo.save(userReader);
//        var id = userReader.getId();
//        assertNotEquals(0, id);
//
//        userReaderRepo.deleteById(id);
//
    }

}