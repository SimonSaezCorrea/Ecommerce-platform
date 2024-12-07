package demo.schoolar.service;

import demo.schoolar.entity.SchoolEntity;
import demo.schoolar.repository.SchoolRepository;
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

    public SchoolEntity findByName(String name) {
        return schoolRepository.findByName(name);
    }

    public SchoolEntity login(String name) {
        return findByName(name);
    }
}
