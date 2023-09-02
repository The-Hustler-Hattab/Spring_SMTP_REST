package com.mtattab.emailservice.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AESTest {

    @Autowired
    private AESEncryption aesEncryption;

    @Test
    public void testEncryptionAndDecryption() throws Exception {
        String originalText = "test test";

        String encryptedText = aesEncryption.encrypt(originalText);
        String decryptedText = aesEncryption.decrypt(encryptedText);
        System.out.println(encryptedText);
        System.out.println(originalText);
        System.out.println(decryptedText);

        assertEquals(originalText, decryptedText);
    }
}
