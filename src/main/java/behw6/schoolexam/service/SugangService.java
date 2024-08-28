package behw6.schoolexam.service;

import behw6.schoolexam.entity.Student;
import behw6.schoolexam.entity.Sugang;
import behw6.schoolexam.repository.SugangRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SugangService {


    private final StudentService studentService;
    private final SugangRepository sugangRepository;

    public SugangService(StudentService studentService, SugangRepository sugangRepository) {
        this.studentService = studentService;
        this.sugangRepository = sugangRepository;
    }

    public void create(int id, Sugang sugang) {
        Student student = studentService.readdetail(id);

        sugang.setStudent(student);
        sugang.setDate(LocalDateTime.now());

        sugangRepository.save(sugang);
    }
}
