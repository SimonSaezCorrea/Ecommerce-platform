package e_commerce_multitenant.multitenant.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String SECRET_KEY = "1234567890123456"; // Debe tener 16, 24 o 32 caracteres
    private static final String ENCRYPTED_PREFIX = "ENC|";

    public static String encrypt(String strToEncrypt) throws Exception {
        if (strToEncrypt == null) return null;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String encrypted = Base64.getEncoder().encodeToString(
                cipher.doFinal(strToEncrypt.getBytes("UTF-8"))
        );
        return ENCRYPTED_PREFIX + encrypted;
    }

    public static String decrypt(String strToDecrypt) throws Exception {
        if (!isEncrypted(strToDecrypt)) return strToDecrypt;
        try {
            String base64Encrypted = strToDecrypt.substring(ENCRYPTED_PREFIX.length());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(base64Encrypted));
            return new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            return strToDecrypt;
        }
    }

    public static boolean isEncrypted(String value) {
        return value != null && value.startsWith(ENCRYPTED_PREFIX);
    }
}
