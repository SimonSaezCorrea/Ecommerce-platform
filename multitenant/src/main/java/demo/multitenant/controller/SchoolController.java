package demo.multitenant.controller;

import demo.multitenant.entity.CourseEntity;
import demo.multitenant.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<CourseEntity> saveCourse(CourseEntity courseEntity) {
        return ResponseEntity.ok(courseService.saveCourse(courseEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseEntity> deleteCourse(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }

    @PutMapping("/")
    public ResponseEntity<CourseEntity> updateCourse(CourseEntity courseEntity) {
        return ResponseEntity.ok(courseService.updateCourse(courseEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseEntity>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}
