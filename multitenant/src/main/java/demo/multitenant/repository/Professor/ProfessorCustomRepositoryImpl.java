package demo.multitenant.repository.Professor;

import demo.multitenant.entity.ProfessorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProfessorCustomRepositoryImpl implements ProfessorCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public ProfessorEntity save(ProfessorEntity professorEntity, String schemaName) {
        // Construir la consulta dinámica
        String sql = "INSERT INTO " + schemaName + ".professor (id, name, email) VALUES (?, ?, ?)";
        Query query = entityManager.createNativeQuery(sql, ProfessorEntity.class);
        query.setParameter(1, professorEntity.getId());
        query.setParameter(2, professorEntity.getName());
        query.setParameter(3, professorEntity.getEmail());

        // Ejecutar la consulta y devolver el resultado
        query.executeUpdate();
        return professorEntity;
    }

    @Override
    public List<ProfessorEntity> findAllBySchema(String schemaName) {
        // Construir la consulta dinámica
        String sql = "SELECT * FROM " + schemaName + ".professor";
        Query query = entityManager.createNativeQuery(sql, ProfessorEntity.class);
        // Ejecutar la consulta y devolver los resultados
        return query.getResultList();
    }

    @Override
    public ProfessorEntity findByIdAndSchema(Integer id, String schemaName) {
        // Construir la consulta dinámica
        String sql = "SELECT * FROM " + schemaName + ".professor WHERE id = ?";
        Query query = entityManager.createNativeQuery(sql, ProfessorEntity.class);
        query.setParameter(1, id);

        // Ejecutar la consulta y devolver el resultado
        return (ProfessorEntity) query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteByIdAndSchema(Integer id, String schemaName) {
        // Construir la consulta dinámica
        String sql = "DELETE FROM " + schemaName + ".professor WHERE id = ?";
        Query query = entityManager.createNativeQuery(sql, ProfessorEntity.class);
        query.setParameter(1, id);

        // Ejecutar la consulta
        query.executeUpdate();
    }
}
