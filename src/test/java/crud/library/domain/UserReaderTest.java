//package crud.library.domain;
//
//import crud.library.repository.UserReaderRepo;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserReaderTest {
//    @Autowired
//    UserReaderRepo userReaderRepo;
//
//    @Test
//    void findAllTest(){
//        UserReader userReader = new UserReader("test ","test_nazwisko", LocalDate.now());
//        userReaderRepo.save(userReader);
//        var id = userReader.getId();
//        var all = userReaderRepo.findAll();
//        assertEquals(1,all.size());
//        userReaderRepo.deleteById(id);
//    }
//
//}