package demo.multitenant.controller;

import demo.multitenant.entity.DataSourceEntity;
import demo.multitenant.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/datasource")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    // -----------------------------------------------------------------------------------------------------------------
    // Get
    // -----------------------------------------------------------------------------------------------------------------

    // Obtiene la configuración de la fuente de datos con el id
    @GetMapping("/get/{id}")
    public ResponseEntity<DataSourceEntity> getDataSourceConfigById(@PathVariable UUID id) {
        DataSourceEntity dataSource = dataSourceService.getDataSourceConfigById(id);
        return new ResponseEntity<>(dataSource, HttpStatus.OK);
    }

    // Obtiene la configuración de la fuente de datos con el nombre
    @GetMapping("/get/name/{name}")
    public ResponseEntity<List<DataSourceEntity>> getDataSourceConfigByName(@PathVariable String name) {
        List<DataSourceEntity> dataSource = dataSourceService.getDataSourceConfigByName(name);
        return new ResponseEntity<>(dataSource, HttpStatus.OK);
    }

    // Obtiene la configuración de la fuente de datos con el establecimiento
    @GetMapping("/get/establecimiento/{establecimiento}")
    public ResponseEntity<List<DataSourceEntity>> getDataSourceConfigByEstablecimiento(@PathVariable String establecimiento) {
        List<DataSourceEntity> dataSource = dataSourceService.getDataSourceConfigByEstablecimiento(establecimiento);
        System.out.println("dataSource: " + dataSource);
        return new ResponseEntity<>(dataSource, HttpStatus.OK);
    }

    // Obtiene todas las configuraciones de las fuentes de datos
    @GetMapping("/get/all")
    public ResponseEntity<List<DataSourceEntity>> getAllDataSourceConfig() {
        List<DataSourceEntity> dataSource = dataSourceService.getAllDataSourceConfig();
        return new ResponseEntity<>(dataSource, HttpStatus.OK);
    }

    @GetMapping("/encrypt")
    public ResponseEntity<Void> encryptDataSourceConfig() {
        dataSourceService.encryptDataSourceConfig();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
