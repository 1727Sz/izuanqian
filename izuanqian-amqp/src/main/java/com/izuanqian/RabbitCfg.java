/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import org.springframework.amqp.core.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author sanlion
 */
@Configuration
public class RabbitCfg {

    @Bean
    public Queue Q00AQueue() {
        return new Queue("Q.00A");
    }
}
