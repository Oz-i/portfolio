package crud.library.mapper;

import crud.library.domain.UserReader;
import crud.library.domain.dto.UserReaderDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserMapper {
    public UserReader mapUserReaderDtoToUserReader(final UserReaderDto userReaderDto){
        return UserReader.builder()
                .name(userReaderDto.getName())
                .surname(userReaderDto.getSurname())
                .borrowed(userReaderDto.getBorrowed())
                .build();
    }
    public UserReaderDto mapUserReaderToUserReaderDTO(final UserReader userReader){
        return UserReaderDto.builder()
                .id(userReader.getId())
                .name(userReader.getName())
                .surname(userReader.getSurname())
                .borrowed(userReader.getBorrowed())
                .build();
    }
    public List<UserReaderDto>mapListToUserReaderDTOList(final List<UserReader>list){
        return list.stream()
                .map(this::mapUserReaderToUserReaderDTO)
                .collect(Collectors.toList());
    }
}
