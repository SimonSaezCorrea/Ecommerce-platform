package demo.multitenant.service;

import demo.multitenant.entity.ProfessorEntity;
import demo.multitenant.repository.Professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorEntity saveProfessor(ProfessorEntity professorEntity, String schemaName) {
        return professorRepository.save(professorEntity, schemaName);
    }

    public ProfessorEntity deleteProfessor(Integer id, String schemaName){
        ProfessorEntity professorEntity = getProfessorById(id, schemaName);
        professorRepository.deleteByIdAndSchema(id, schemaName);
        return professorEntity;
    }

    public ProfessorEntity updateProfessor(ProfessorEntity professorEntity, String schemaName) {
        return professorRepository.save(professorEntity, schemaName);
    }

    public ProfessorEntity getProfessorById(Integer id, String schemaName) {
        return professorRepository.findByIdAndSchema(id, schemaName);
    }

    public List<ProfessorEntity> getAllProfessors(String schemaName) {
        return professorRepository.findAllBySchema(schemaName);
    }
}
