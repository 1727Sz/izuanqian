/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian.redis;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author sanlion
 */
@Component
public class Redis4HashOps {

    @Autowired
    private StringRedisTemplate template;

    /**
     * put single object into hash
     *
     * @param key
     * @param field
     * @param object
     */
    public void put(String key, String field, Object object) {
        if (Strings.isNullOrEmpty(field) || object == null) {
            return;
        }
        template.opsForHash().put(key, field, object);
    }

    /**
     * put multiple object into hash
     *
     * @param key
     * @param map
     */
    public void putALl(String key, Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        template.opsForHash().putAll(key, map);
    }

}
