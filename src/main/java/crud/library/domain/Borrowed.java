package crud.library.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity(name = "borrowed_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "copy_id")
    private Copy copy;
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private UserReader reader;
    private boolean returned;
    @Column(name = "borrow_date")
    private LocalDate loanOfDate;
    @Column(name = "return_date")
    private LocalDate returnOfDate;
}
