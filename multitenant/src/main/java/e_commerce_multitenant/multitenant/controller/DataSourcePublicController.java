package e_commerce_multitenant.multitenant.controller

-commerce-multitenant.multitenant.controller;

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

@RestController
@RequestMapping("/datasource/public")
public class DataSourcePublicController {

    @Autowired
    private DataSourceService dataSourceService;

    // Obtiene la configuración de la fuente de datos con el establecimiento
    @GetMapping("/get/establecimiento/{establecimiento}")
    public ResponseEntity<List<DataSourceEntity>> getDataSourceConfigByEstablecimiento(@PathVariable String establecimiento) {
        List<DataSourceEntity> dataSource = dataSourceService.getDataSourceConfigByEstablecimiento(establecimiento);
        System.out.println("dataSource: " + dataSource);
        return new ResponseEntity<>(dataSource, HttpStatus.OK);
    }
}
