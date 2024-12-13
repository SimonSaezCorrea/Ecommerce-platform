package demo.multitenant.repository.Student;

import demo.multitenant.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentCustomRepositoryImpl implements StudentCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public StudentEntity save(StudentEntity studentEntity, String schemaName) {
        // Construir la consulta dinámica
        String sql = "INSERT INTO " + schemaName + ".student (id, name, email, id_course) VALUES (?, ?, ?, ?)";
        Query query = entityManager.createNativeQuery(sql, StudentEntity.class);
        query.setParameter(1, studentEntity.getId());
        query.setParameter(2, studentEntity.getName());
        query.setParameter(3, studentEntity.getEmail());
        query.setParameter(4, studentEntity.getId_course());

        // Ejecutar la consulta y devolver el resultado
        query.executeUpdate();
        return studentEntity;
    }

    @Override
    public List<StudentEntity> findAllBySchema(String schemaName) {
        // Construir la consulta dinámica
        String sql = "SELECT * FROM " + schemaName + ".student";
        Query query = entityManager.createNativeQuery(sql, StudentEntity.class);

        // Ejecutar la consulta y devolver los resultados
        return query.getResultList();
    }

    @Override
    public StudentEntity findByIdAndSchema(Integer id, String schemaName) {
        // Construir la consulta dinámica
        String sql = "SELECT * FROM " + schemaName + ".student WHERE id = ?";
        Query query = entityManager.createNativeQuery(sql, StudentEntity.class);
        query.setParameter(1, id);

        // Ejecutar la consulta y devolver el resultado
        return (StudentEntity) query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteByIdAndSchema(Integer id, String schemaName) {
        // Construir la consulta dinámica
        String sql = "DELETE FROM " + schemaName + ".student WHERE id = ?";
        Query query = entityManager.createNativeQuery(sql, StudentEntity.class);
        query.setParameter(1, id);

        // Ejecutar la consulta
        query.executeUpdate();
    }
}
