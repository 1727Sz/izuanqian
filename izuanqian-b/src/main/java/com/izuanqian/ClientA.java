/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanlion
 */
@RestController
public class ClientA {
    
    @Autowired private DiscoveryClient discoveryClient;
    
    @GetMapping("/now")
    public String getCurrentTime(){
        System.out.println(discoveryClient.getLocalServiceInstance().getHost());
        return "b.service：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
