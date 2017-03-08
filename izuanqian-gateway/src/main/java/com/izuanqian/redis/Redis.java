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


    public static void main(String[] args) {

        transform(Long.MAX_VALUE,62);
    }

    /**
     * @param args
     */

    public static void transform(long num, int n) {
        //参数num为输入的十进制数，参数n为要转换的进制
        long array[] = new long[11];
        int location = 0;
        while (num != 0) {//当输入的数不为0时循环执行求余和赋值
            long remainder = num % n;
            num = num / n;
            array[location] = remainder;//将结果加入到数组中去
            location++;
        }
        show(array, location - 1);

    }

    private static void show(long[] arr, int n) {
        String key = "tcd8WPqMLVYEgDspfwX4xQo5SFbNHIa3mAierCUkv61hR2079ZzGKnTyjBJOlu";
        System.out.println(key.charAt(0));
        for (int i = n; i >= 0; i--) {
            System.out.println(arr[i] +" => "+key.charAt((int)arr[i]));
        }
//            if (arr[i] > 9) {
//                System.out.print((char) (arr[i] + 55));
//            } else
//                System.out.print(arr[i] + "");
//        }
    }


}
