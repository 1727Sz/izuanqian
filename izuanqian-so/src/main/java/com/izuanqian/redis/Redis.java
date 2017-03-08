/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author sanlion
 */
@Component
public class Redis {

    @Autowired
    private StringRedisTemplate template;

    /**
     * get url.id from redis by incr
     *
     * @return
     */
    public long nextKey() {
        return template.opsForValue().increment("URL:ID", 1);
    }

    /**
     * save url
     *
     * @param url
     * @param originalUrl
     */
    public void save(String url, String originalUrl) {
        template.opsForHash().put("URL", url, originalUrl);
    }

}
