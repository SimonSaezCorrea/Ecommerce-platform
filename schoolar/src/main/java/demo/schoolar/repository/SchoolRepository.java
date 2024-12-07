package demo.schoolar.repository;

import demo.schoolar.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Integer> {

    @Query("SELECT e FROM SchoolEntity e WHERE e.name = :name")
    SchoolEntity findByName(@Param("name") String name);
}
