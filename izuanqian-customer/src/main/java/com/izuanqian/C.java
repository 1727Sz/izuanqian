/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author sanlion
 */
@FeignClient("bservice")
public interface C {

    @GetMapping("/now")
    public String getCurrentTime();
}
