package behw6.schoolexam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Sugang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "강의 제목은 필수 항목입니다.")
    private String subject;

    private String code;
    private String etc;

    private LocalDateTime date;

    @ManyToOne
    private Student student;
}