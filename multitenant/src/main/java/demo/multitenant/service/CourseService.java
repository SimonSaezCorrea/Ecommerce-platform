package demo.multitenant.service;

import demo.multitenant.entity.CourseEntity;
import demo.multitenant.repository.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity saveCourse(CourseEntity courseEntity, String schemaName) {
        return courseRepository.save(courseEntity, schemaName);
    }

    public CourseEntity deleteCourse(Integer id, String schemaName){
        CourseEntity courseEntity = getCourseById(id, schemaName);
        courseRepository.deleteByIdAndSchema(id, schemaName);
        return courseEntity;
    }

    public CourseEntity updateCourse(CourseEntity courseEntity, String schemaName) {
        return courseRepository.save(courseEntity, schemaName);
    }

    public CourseEntity getCourseById(Integer id, String schemaName) {
        return courseRepository.findByIdAndSchema(id, schemaName);
    }

    public List<CourseEntity> getAllCourses(String schemaName) {
        return courseRepository.findAllBySchema(schemaName);
    }
}
