/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author sanlion
 */
@Component
public class ToFtp extends RouteBuilder{

    private String locationDir = "file:C:/ftp_root";
    @Override
    public void configure() throws Exception {
        System.out.println("开始处理：");
        from(locationDir).process(new Processor() {
            @Override
            public void process(Exchange exchng) throws Exception {
                Message message = exchng.getIn();
                System.out.println("==========》"+message);
            }
        }).to("stream:out");
    }
    
}
