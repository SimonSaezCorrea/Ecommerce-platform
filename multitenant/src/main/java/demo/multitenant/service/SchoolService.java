package demo.multitenant.service;

import demo.multitenant.entity.SchoolEntity;
import demo.multitenant.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public SchoolEntity saveSchool(SchoolEntity schoolEntity) {
        return schoolRepository.save(schoolEntity);
    }

    public SchoolEntity deleteSchool(Integer id) {
        SchoolEntity schoolEntity = getSchoolById(id);
        schoolRepository.deleteById(id);
        return schoolEntity;
    }

    public SchoolEntity updateSchool(SchoolEntity schoolEntity) {
        return schoolRepository.save(schoolEntity);
    }

    public SchoolEntity getSchoolById(Integer id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public List<SchoolEntity> getAllSchools() {
        return schoolRepository.findAll();
    }
}
