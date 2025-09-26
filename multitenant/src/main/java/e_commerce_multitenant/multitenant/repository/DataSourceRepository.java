package e_commerce_multitenant.multitenant.repository;

import e_commerce_multitenant.multitenant.entity.DataSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSourceEntity, UUID> {

    @Query("SELECT d FROM DataSourceEntity d WHERE d.establecimiento = ?1")
    List<DataSourceEntity> findByEstablecimiento(String establecimiento);

    @Query("SELECT d FROM DataSourceEntity d WHERE d.name = ?1")
    List<DataSourceEntity> findByName(String name);
}
