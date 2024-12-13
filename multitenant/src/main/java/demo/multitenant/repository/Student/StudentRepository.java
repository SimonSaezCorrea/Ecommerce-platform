package demo.multitenant.repository.Student;

import demo.multitenant.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>, StudentCustomRepository {
}
