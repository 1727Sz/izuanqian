/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian.redis;

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
public class Redis {

    @Autowired
    private StringRedisTemplate template;

    public <T> T get(String key, Class<T> clazz) {
        return new Gson().fromJson(template.opsForValue().get(key), clazz);
    }

    public void set(String key, Object object) {
        template.opsForValue().set(key, new Gson().toJson(object));
    }

    public <T> Set<T> members(String key, Class<T> clazz) {
        Set<String> set = template.opsForSet().members(key);
        if (CollectionUtils.isEmpty(set)) {
            return Collections.EMPTY_SET;
        }
        JsonArray array = new JsonArray();
        for (String s : set) {
            array.add(s);
        }
        return new Gson().fromJson(array, HashSet.class);
    }

    public void a(String key, Object object) {
        template.opsForSet().add(key, new Gson().toJson(object));
    }

    public void a(String key, Set objects) {

        if (!CollectionUtils.isEmpty(objects)) {
            List<String> values = new ArrayList<>();
            for (java.lang.Object object : objects) {
                values.add(new Gson().toJson(object));
            }
            template.opsForSet().add(key, values.toArray(new String[values.size()]));
        }
    }

}
