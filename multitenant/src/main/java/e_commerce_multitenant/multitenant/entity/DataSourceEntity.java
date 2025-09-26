package e_commerce_multitenant.multitenant.entity;

import e_commerce_multitenant.multitenant.util.AESEncryptionConverter;
import e_commerce_multitenant.multitenant.util.AESUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "data_source")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DataSourceEntity {

    @Id
    private UUID id;

    @Convert(converter = AESEncryptionConverter.class)
    private String name;
    @Convert(converter = AESEncryptionConverter.class)
    private String url;
    @Convert(converter = AESEncryptionConverter.class)
    private String username;
    @Convert(converter = AESEncryptionConverter.class)
    private String password;

    @Column(name = "driver_class_name")
    @Convert(converter = AESEncryptionConverter.class)
    private String driverClassName;

    private Boolean initialize;
    @Convert(converter = AESEncryptionConverter.class)
    private String establecimiento;
    @Convert(converter = AESEncryptionConverter.class)
    private String service;

    @PrePersist
    @PreUpdate
    private void encryptFields() {
        try {
            name = encryptIfNeeded(name);
            url = encryptIfNeeded(url);
            username = encryptIfNeeded(username);
            password = encryptIfNeeded(password);
            driverClassName = encryptIfNeeded(driverClassName);
            establecimiento = encryptIfNeeded(establecimiento);
            service = encryptIfNeeded(service);
        } catch (Exception e) {
            throw new RuntimeException("Error encriptando campos del docente", e);
        }
    }

    @PostLoad
    private void decryptFields() {
        try {
            name = decryptIfNeeded(name);
            url = decryptIfNeeded(url);
            username = decryptIfNeeded(username);
            password = decryptIfNeeded(password);
            driverClassName = decryptIfNeeded(driverClassName);
            establecimiento = decryptIfNeeded(establecimiento);
            service = decryptIfNeeded(service);
        } catch (Exception e) {
            throw new RuntimeException("Error desencriptando campos del docente", e);
        }
    }

    public String encryptIfNeeded(String value) throws Exception {
        if (value != null && !AESUtil.isEncrypted(value)) {
            return AESUtil.encrypt(value);
        }
        return value;
    }

    private String decryptIfNeeded(String value) throws Exception {
        if (AESUtil.isEncrypted(value)) {
            return AESUtil.decrypt(value);
        }
        return value;
    }
}
