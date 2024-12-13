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
    @PostMapping("/create")
    public ResponseEntity<ProfessorEntity> saveProfessor(@RequestBody ProfessorEntity professorEntity, @RequestParam String schemaName) {
        return ResponseEntity.ok(professorService.saveProfessor(professorEntity, schemaName));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProfessorEntity> deleteProfessor(@PathVariable Integer id, @RequestParam String schemaName) {
        return ResponseEntity.ok(professorService.deleteProfessor(id, schemaName));
    }

    @PutMapping("/update")
    public ResponseEntity<ProfessorEntity> updateProfessor(@RequestBody ProfessorEntity professorEntity, @RequestParam String schemaName) {
        return ResponseEntity.ok(professorService.updateProfessor(professorEntity, schemaName));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProfessorEntity> getProfessorById(@PathVariable Integer id, @RequestParam String schemaName) {
        return ResponseEntity.ok(professorService.getProfessorById(id, schemaName));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProfessorEntity>> getAllProfessors(@RequestParam String schemaName) {
        return ResponseEntity.ok(professorService.getAllProfessors(schemaName));
    }
}
