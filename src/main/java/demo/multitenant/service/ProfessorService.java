package demo.multitenant.service;

import demo.multitenant.entity.ProfessorEntity;
import demo.multitenant.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorEntity saveProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity deleteProfessor(Integer id){
        ProfessorEntity professorEntity = getProfessorById(id);
        professorRepository.deleteById(id);
        return professorEntity;
    }

    public ProfessorEntity updateProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity getProfessorById(Integer id) {
        return professorRepository.findById(id).orElse(null);
    }

    public List<ProfessorEntity> getAllProfessors() {
        return professorRepository.findAll();
    }
}
