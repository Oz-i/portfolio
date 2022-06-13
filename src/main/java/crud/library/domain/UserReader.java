package crud.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "user_reader")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserReader {

    @Id
    @GeneratedValue()
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_surname")
    private String surname;
    @Column(name = "date_insertion")
    private final LocalDate dateOfCardInsertion = LocalDate.now();
    @JsonIgnore
    @OneToMany(
            targetEntity = Borrowed.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrowed> borrowed;
}
