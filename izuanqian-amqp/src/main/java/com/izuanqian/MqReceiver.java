/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author sanlion
 */
@Component
@RabbitListener(queues = {"Q.00A"})
public class MqReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println(message);

    }
}
