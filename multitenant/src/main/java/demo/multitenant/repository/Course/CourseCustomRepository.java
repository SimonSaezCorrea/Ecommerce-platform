package demo.multitenant.repository.Course;

import demo.multitenant.entity.CourseEntity;

import java.util.List;

public interface CourseCustomRepository {

    CourseEntity save(CourseEntity courseEntity, String schemaName);
    List<CourseEntity> findAllBySchema(String schemaName);
    CourseEntity findByIdAndSchema(Integer id, String schemaName);
    void deleteByIdAndSchema(Integer id, String schemaName);
}
