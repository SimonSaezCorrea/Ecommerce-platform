package demo.multitenant.controller;

import demo.multitenant.entity.StudentEntity;
import demo.multitenant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public StudentEntity saveStudent(StudentEntity studentEntity) {
        return studentService.saveStudent(studentEntity);
    }

    @DeleteMapping("/{id}")
    public StudentEntity deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/")
    public StudentEntity updateStudent(StudentEntity studentEntity) {
        return studentService.updateStudent(studentEntity);
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }
}
