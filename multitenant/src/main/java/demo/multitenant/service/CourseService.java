package demo.multitenant.service;

import demo.multitenant.entity.CourseEntity;
import demo.multitenant.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity saveCourse(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }

    public CourseEntity deleteCourse(Integer id){
        CourseEntity courseEntity = getCourseById(id);
        courseRepository.deleteById(id);
        return courseEntity;
    }

    public CourseEntity updateCourse(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }

    public CourseEntity getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }
}
