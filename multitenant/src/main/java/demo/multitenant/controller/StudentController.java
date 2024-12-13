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

    @PostMapping("/create")
    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity, @RequestParam String schemaName) {
        return studentService.saveStudent(studentEntity, schemaName);
    }

    @DeleteMapping("/delete/{id}")
    public StudentEntity deleteStudent(@PathVariable Integer id, @RequestParam String schemaName) {
        return studentService.deleteStudent(id, schemaName);
    }

    @PutMapping("/update")
    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity, @RequestParam String schemaName) {
        return studentService.updateStudent(studentEntity, schemaName);
    }

    @GetMapping("/get/{id}")
    public StudentEntity getStudentById(@PathVariable Integer id, @RequestParam String schemaName) {
        return studentService.getStudentById(id, schemaName);
    }

    @GetMapping("/getall")
    public List<StudentEntity> getAllStudents(@RequestParam String schemaName) {
        return studentService.getAllStudents(schemaName);
    }
}
