package behw6.schoolexam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String username;
    private String password;
    private String addr;
    private String phone;

    @OneToMany
    private List<Sugang> sugangs;

    private LocalDateTime date;
}
