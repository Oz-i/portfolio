package crud.library.book;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.library.domain.Book;
import crud.library.domain.dto.BookDto;
import crud.library.repository.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestBookController {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BookRepo bookRepo;

    @Test
    @Transactional
    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
    void getAllBooks() throws Exception{
        List<Book> bookList = new ArrayList<>();
        bookList.add(Book.builder().id(1L).title("T").author("A").yearOfPublication(100).build());
        bookList.add(Book.builder().id(2L).title("2").author("3").build());
        bookRepo.saveAll(bookList);

        MvcResult mvcResult = mockMvc.perform(get("/v1/book"))
                .andExpect(status().is(200))
                .andReturn();
        List<BookDto> response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
        });
        assertThat(response).hasSize(2);
    }
}
