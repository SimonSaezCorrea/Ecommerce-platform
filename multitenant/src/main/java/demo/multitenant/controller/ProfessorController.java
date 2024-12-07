package demo.multitenant.controller;

import demo.multitenant.entity.ProfessorEntity;
import demo.multitenant.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    // Add methods here
    @PostMapping("/")
    public ResponseEntity<ProfessorEntity> saveProfessor(ProfessorEntity professorEntity) {
        return ResponseEntity.ok(professorService.saveProfessor(professorEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessorEntity> deleteProfessor(@PathVariable Integer id) {
        return ResponseEntity.ok(professorService.deleteProfessor(id));
    }

    @PutMapping("/")
    public ResponseEntity<ProfessorEntity> updateProfessor(ProfessorEntity professorEntity) {
        return ResponseEntity.ok(professorService.updateProfessor(professorEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorEntity> getProfessorById(@PathVariable Integer id) {
        return ResponseEntity.ok(professorService.getProfessorById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProfessorEntity>> getAllProfessors() {
        return ResponseEntity.ok(professorService.getAllProfessors());
    }
}
