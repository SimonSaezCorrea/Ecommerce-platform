package demo.multitenant.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AESEncryptionConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            if (attribute != null && !AESUtil.isEncrypted(attribute)) {
                return AESUtil.encrypt(attribute);
            }
            return attribute;
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting value", e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            if (AESUtil.isEncrypted(dbData)) {
                return AESUtil.decrypt(dbData);
            }
            return dbData;
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting value", e);
        }
    }
}

