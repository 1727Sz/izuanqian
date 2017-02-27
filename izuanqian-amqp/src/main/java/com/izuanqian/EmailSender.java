/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author sanlion
 */
@Component
public class EmailSender {

    @Autowired private JavaMailSender sender;

    public void send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sanlion@vip.qq.com");
        message.setTo("sanlion@vip.qq.com");
        message.setSubject("spring boot 集成邮件发送测试00A");
        message.setText("发送内容，如题。↑");
        sender.send(message);
    }

    /**
     * 带附件
     *
     * @throws javax.mail.MessagingException
     */
    public void sendMimeMessage() throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("sanlion@vip.qq.com");
        helper.setTo("sanlion@vip.qq.com");
        helper.setSubject("spring boot 集成邮件发送测试00B，有附件");
        helper.setText("<html><body>html页面<img src=\"cid:jpg\"></body></html>", true);
        FileSystemResource resource = new FileSystemResource(Paths.get("C:", "ftp_root", "2017", "02", "24", "bulogo.jpg").toString());
        helper.addAttachment("附件-一张美图.jpg", resource);
        helper.addInline("jpg", resource);
        sender.send(message);
    }
}
