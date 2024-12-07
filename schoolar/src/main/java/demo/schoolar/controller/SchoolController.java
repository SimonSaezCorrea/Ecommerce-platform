package demo.schoolar.controller;

import demo.schoolar.entity.SchoolEntity;
import demo.schoolar.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/")
    public ResponseEntity<SchoolEntity> saveSchool(@RequestBody SchoolEntity schoolEntity) {
        return ResponseEntity.ok(schoolService.saveSchool(schoolEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SchoolEntity> deleteSchool(@PathVariable Integer id) {
        return ResponseEntity.ok(schoolService.deleteSchool(id));
    }

    @PutMapping("/")
    public ResponseEntity<SchoolEntity> updateSchool(@RequestBody SchoolEntity schoolEntity) {
        return ResponseEntity.ok(schoolService.updateSchool(schoolEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolEntity> getSchoolById(@PathVariable Integer id) {
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<SchoolEntity>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }
}
