package crud.library.controller;

import crud.library.domain.UserReader;
import crud.library.domain.dto.UserReaderDto;
import crud.library.mapper.UserMapper;
import crud.library.service.UserReaderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/user")
@AllArgsConstructor
public class UserController {
    private final UserReaderService userReaderService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserReader>getAll(){
        return userReaderService.findAllUsers();
    }
    @PostMapping("addUser")
    public UserReader addUser(@RequestBody @Valid UserReaderDto userReaderDto){
        return userReaderService.addUser(userMapper.mapUserReaderDtoToUserReader(userReaderDto));
    }
}
