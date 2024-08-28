package behw6.schoolexam.service;

import behw6.schoolexam.entity.Student;
import behw6.schoolexam.repository.StudentRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    public void create(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
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
