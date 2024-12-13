package demo.multitenant.repository.Course;

import demo.multitenant.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseCustomRepositoryImpl implements CourseCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public CourseEntity save(CourseEntity courseEntity, String schemaName) {
        // Construir la consulta dinámica
        String sql = "INSERT INTO " + schemaName + ".course (id, name, description, id_professor) VALUES (?, ?, ?, ?)";
        Query query = entityManager.createNativeQuery(sql, CourseEntity.class);
        query.setParameter(1, courseEntity.getId());
        query.setParameter(2, courseEntity.getName());
        query.setParameter(3, courseEntity.getDescription());
        query.setParameter(4, courseEntity.getId_professor());

        // Ejecutar la consulta y devolver el resultado
        query.executeUpdate();
        return courseEntity;
    }

    @Override
    public List<CourseEntity> findAllBySchema(String schemaName) {
        // Construir la consulta dinámica
        String sql = "SELECT * FROM " + schemaName + ".course";
        Query query = entityManager.createNativeQuery(sql, CourseEntity.class);

        // Ejecutar la consulta y devolver los resultados
        return query.getResultList();
    }

    @Override
    public CourseEntity findByIdAndSchema(Integer id, String schemaName) {
        // Construir la consulta dinámica
        String sql = "SELECT * FROM " + schemaName + ".course WHERE id = ?";
        Query query = entityManager.createNativeQuery(sql, CourseEntity.class);
        query.setParameter(1, id);

        // Ejecutar la consulta y devolver el resultado
        return (CourseEntity) query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteByIdAndSchema(Integer id, String schemaName) {
        // Construir la consulta dinámica
        String sql = "DELETE FROM " + schemaName + ".course WHERE id = ?";
        Query query = entityManager.createNativeQuery(sql, CourseEntity.class);
        query.setParameter(1, id);

        // Ejecutar la consulta
        query.executeUpdate();
    }
}
