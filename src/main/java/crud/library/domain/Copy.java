package crud.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import crud.library.enumClass.BookCopyStatus;
import crud.library.exception.BookStatusNotFound;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamedNativeQuery(
        name = "Copy.getCopiesByStatus",
        query = "SELECT * FROM book_copies"+
                " WHERE copy_status = :STATUS",
        resultClass = Copy.class
)

@Entity(name = "book_copies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Copy {


    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private Long id;
    @NotNull
    @Column(name = "copy_status")
    @Enumerated(EnumType.STRING)
    private BookCopyStatus status;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;
    @NotNull
    @Column(name = "in_stock")
    private boolean canBeBorrow;
    @JsonIgnore
    @OneToMany(mappedBy = "copy", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Borrowed> borrowsList;
    public void setStatus(String status) {
        status = status.toLowerCase();

        switch (status) {
            case "in use":
                this.status = BookCopyStatus.IN_USE;
                this.canBeBorrow = true;
                break;
            case "in renovation":
                this.status = BookCopyStatus.IN_RENOVATION;
                this.canBeBorrow = false;
                break;
            case"lost":
                this.status = BookCopyStatus.LOST;
                this.canBeBorrow = false;
                break;
            case "destroyed":
                this.status = BookCopyStatus.DESTROYED;
                this.canBeBorrow = false;
                break;
            default:
                throw new BookStatusNotFound();
        }
    }
}
