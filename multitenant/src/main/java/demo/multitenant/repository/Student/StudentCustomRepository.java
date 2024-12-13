package demo.multitenant.repository.Student;

import demo.multitenant.entity.StudentEntity;

import java.util.List;

public interface StudentCustomRepository {

    StudentEntity save(StudentEntity studentEntity, String schemaName);
    List<StudentEntity> findAllBySchema(String schemaName);
    StudentEntity findByIdAndSchema(Integer id, String schemaName);
    void deleteByIdAndSchema(Integer id, String schemaName);
}
