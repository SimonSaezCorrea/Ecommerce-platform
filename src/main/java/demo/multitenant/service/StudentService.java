package demo.multitenant.service;

import demo.multitenant.entity.StudentEntity;
import demo.multitenant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity saveStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity deleteStudent(Integer id) {
        StudentEntity studentEntity = getStudentById(id);
        studentRepository.deleteById(id);
        return studentEntity;
    }

    public StudentEntity updateStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
}
