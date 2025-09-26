package e_commerce_multitenant.multitenant.service;

import e_commerce_multitenant.multitenant.entity.DataSourceEntity;
import e_commerce_multitenant.multitenant.repository.DataSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DataSourceService {

    @Autowired
    private DataSourceRepository dataSourceRepository;

    public DataSourceEntity getDataSourceConfigById(UUID id) {
        return dataSourceRepository.findById(id).orElse(null);
    }

    public List<DataSourceEntity> getDataSourceConfigByName(String name) {
        return dataSourceRepository.findByName(name);
    }

    public List<DataSourceEntity> getDataSourceConfigByEstablecimiento(String establecimiento) {
        System.out.println("establecimiento: " + establecimiento);

        return dataSourceRepository.findByEstablecimiento(establecimiento);
    }

    public List<DataSourceEntity> getAllDataSourceConfig() {
        return dataSourceRepository.findAll();
    }

    public void encryptDataSourceConfig() {
        List<DataSourceEntity> dataSourceList = dataSourceRepository.findAll();

        for (DataSourceEntity dataSource : dataSourceList) {
            try{
                dataSource.setName(dataSource.encryptIfNeeded(dataSource.getName()));
                dataSource.setUrl(dataSource.encryptIfNeeded(dataSource.getUrl()));
                dataSource.setUsername(dataSource.encryptIfNeeded(dataSource.getUsername()));
                dataSource.setPassword(dataSource.encryptIfNeeded(dataSource.getPassword()));
                dataSource.setDriverClassName(dataSource.encryptIfNeeded(dataSource.getDriverClassName()));
                dataSource.setEstablecimiento(dataSource.encryptIfNeeded(dataSource.getEstablecimiento()));
                dataSource.setService(dataSource.encryptIfNeeded(dataSource.getService()));
                dataSourceRepository.save(dataSource);
            } catch (Exception e) {
                throw new RuntimeException("Error encriptando campos del datasource", e);
            }
        }
    }
}
