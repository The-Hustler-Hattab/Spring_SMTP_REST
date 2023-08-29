package com.mtattab.emailservice.repository;

import com.mtattab.emailservice.entity.EmailTableEntity;
import com.mtattab.emailservice.util.AESEncryption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmailRepositoryTest {

    @Autowired
    private EmailRepository emailRepository;

    @Test
    public void getAllEmailsTest() {
        List<String> emails= emailRepository.getAllEmailsFromTable();
        System.out.println(emails);
        assertNotNull(emails);

    }

    @Test
    public void getPasswordTest() {
        String password= emailRepository.getPasswordForEmail("TheHustlerMax01@outlook.coM");
        System.out.println(password);
        assertNotNull(password);

    }
}
