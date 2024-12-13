package demo.multitenant.repository.Professor;


import demo.multitenant.entity.ProfessorEntity;

import java.util.List;

public interface ProfessorCustomRepository {

    ProfessorEntity save(ProfessorEntity professorEntity, String schemaName);
    List<ProfessorEntity> findAllBySchema(String schemaName);
    ProfessorEntity findByIdAndSchema(Integer id, String schemaName);
    void deleteByIdAndSchema(Integer id, String schemaName);
}
