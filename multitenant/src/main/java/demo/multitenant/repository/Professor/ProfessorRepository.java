package demo.multitenant.repository.Professor;

import demo.multitenant.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer>, ProfessorCustomRepository {
}
