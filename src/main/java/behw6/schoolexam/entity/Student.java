package behw6.schoolexam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;
    @NotEmpty(message = "전공은 필수항목입니다.")
    private String major;

    private String addr;
    @NotEmpty(message = "전화번호는 필수항목입니다.")
    private String phone;

    private LocalDateTime date;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<Sugang> sugangs;
}
