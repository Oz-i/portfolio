package crud.library.controller;

import crud.library.domain.Copy;
import crud.library.domain.dto.CopyDto;
import crud.library.mapper.CopyMapper;
import crud.library.service.CopyRepoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/copy")
@AllArgsConstructor
@Slf4j
public class CopyController {

    private final CopyMapper copyMapper;
    private final CopyRepoService copyRepoService;


    @GetMapping("status")
    public List<CopyDto> getCopyByStatus(@RequestParam String status){
        return copyMapper.mapToListCopyDTO(copyRepoService.getCopyByStatus(status));
    }
    @GetMapping("{id}")
    public Long countCopyCanBeBorrowById(@PathVariable long id){
        return copyRepoService.countCopyCanBeBorrow(id);
    }
    @PutMapping("{id}/status/{status}")
    public Copy updateCopyStatus(@PathVariable long id, @PathVariable String status){
        return copyRepoService.updateCopyBookStatus(id,status);
    }
    @GetMapping("getAllCopy")
    public List<CopyDto>getAll(){
        return copyMapper.mapToListCopyDTO(copyRepoService.findAllCopy());
    }
    @PostMapping(value = "saveCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCopy(@RequestBody @Valid CopyDto copyDto) {
        copyRepoService.saveCopy(copyMapper.mapToCopy(copyDto));
    }
    @DeleteMapping("{id}")
    public void deleteCopyById(@PathVariable long id){
        copyRepoService.deleteCopyById(id);
    }
}
