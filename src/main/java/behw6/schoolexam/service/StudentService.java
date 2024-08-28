package behw6.schoolexam.service;

import behw6.schoolexam.entity.Student;
import behw6.schoolexam.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 회원가입
    public void create(Student student) {
        student.setDate(LocalDateTime.now());
        studentRepository.save(student);
    }

    public List<Student> readlist(){
        return studentRepository.findAll();
    }

    public Student readdetail(int id){
        Optional<Student> ob = studentRepository.findById(id);
        return ob.get();
    }

}
