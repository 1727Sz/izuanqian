/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author sanlion
 */
@Component
public class Sender {

    @Autowired private AmqpTemplate rabbitTemplate;

    @Async
    public void send() throws InterruptedException {
        String context = "来自星星的问候：" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        rabbitTemplate.convertAndSend("Q.00A", context);
        Thread.sleep(3000);
    }

}
