/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 * @author sanlion
 */
public class Redis extends RedisTemplate<String, Object> {

    private RedisTemplate<String, Object> template;

    public Redis(RedisTemplate template) {
        super();
        this.template = template;
    }

    public <T>RedisTemplate<String, T> __() {
        return (RedisTemplate<String, T>) template;
    }
}
