package demo.multitenant.service;

import demo.multitenant.entity.StudentEntity;
import demo.multitenant.repository.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity saveStudent(StudentEntity studentEntity, String schemaName) {
        return studentRepository.save(studentEntity, schemaName);
    }

    public StudentEntity deleteStudent(Integer id, String schemaName) {
        StudentEntity studentEntity = getStudentById(id, schemaName);
        studentRepository.deleteByIdAndSchema(id, schemaName);
        return studentEntity;
    }

    public StudentEntity updateStudent(StudentEntity studentEntity, String schemaName) {
        return studentRepository.save(studentEntity, schemaName);
    }

    public List<StudentEntity> getAllStudents(String schemaName) {
        return studentRepository.findAllBySchema(schemaName);
    }

    public StudentEntity getStudentById(Integer id, String schemaName) {
        return studentRepository.findByIdAndSchema(id, schemaName);
    }
}
