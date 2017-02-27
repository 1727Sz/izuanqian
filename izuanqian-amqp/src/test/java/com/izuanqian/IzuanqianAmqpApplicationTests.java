package com.izuanqian;

import javax.mail.MessagingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IzuanqianAmqpApplicationTests {
    
    @Autowired private Sender sender;
    @Autowired private EmailSender emailSender;

    @Test
    public void contextLoads() throws InterruptedException, MessagingException {
        
//        emailSender.send();
        emailSender.sendMimeMessage();
    }

}
