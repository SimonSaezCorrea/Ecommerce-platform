package demo.multitenant.controller;

import demo.multitenant.entity.CourseEntity;
import demo.multitenant.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // Add methods here
    @PostMapping("/create")
    public ResponseEntity<CourseEntity> saveCourse(@RequestBody CourseEntity courseEntity, @RequestParam String schemaName) {
        return ResponseEntity.ok(courseService.saveCourse(courseEntity, schemaName));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CourseEntity> deleteCourse(@PathVariable Integer id, @RequestParam String schemaName) {
        return ResponseEntity.ok(courseService.deleteCourse(id, schemaName));
    }

    @PutMapping("/update")
    public ResponseEntity<CourseEntity> updateCourse(@RequestBody CourseEntity courseEntity, @RequestParam String schemaName) {
        return ResponseEntity.ok(courseService.updateCourse(courseEntity, schemaName));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable Integer id, @RequestParam String schemaName) {
        return ResponseEntity.ok(courseService.getCourseById(id, schemaName));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CourseEntity>> getAllCourses(@RequestParam String schemaName) {
        return ResponseEntity.ok(courseService.getAllCourses(schemaName));
    }

}
