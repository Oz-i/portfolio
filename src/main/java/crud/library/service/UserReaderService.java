package crud.library.service;

import crud.library.domain.UserReader;
import crud.library.repository.UserReaderRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserReaderService {
    private final UserReaderRepo userReaderRepo;

    public List<UserReader>findAllUsers(){
        return userReaderRepo.findAll();
    }
    public UserReader getUserById(Long id){
        return userReaderRepo.getById(id);
    }
    @Transactional
    public UserReader addUser(UserReader userReader){
        return userReaderRepo.save(userReader);
    }
}
