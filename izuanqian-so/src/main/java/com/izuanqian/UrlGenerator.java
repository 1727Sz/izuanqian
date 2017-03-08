package com.izuanqian;

import com.izuanqian.redis.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 17-3-8.
 */
@Component
public class UrlGenerator {

    @Value("${cn.ilive.so.random}")
    private String random;
    @Value("${cn.ilive.so.doamin}")
    private String domain;

    @Autowired private Redis redisListOps;

    public String nextUrl() {
        long id = redisListOps.nextKey();
        StringBuilder sb = new StringBuilder("http://");
        sb.append(domain);
        sb.append("/");
        sb.append(wrapper(to62(id)));
        String url = sb.toString();
        return url;
    }

    private List<Long> to62(long original) {
        int n = 62;
        //参数original为输入的十进制数，参数n为要转换的进制
//        long array[] = new long[11];
        List<Long> array = new ArrayList<>();
        int location = 0;
        while (original != 0) {//当输入的数不为0时循环执行求余和赋值
            long remainder = original % n;
            original /= n;
            array.add(original); //将结果加入到数组中去
        }
        Collections.reverse(array);
        return array;
    }

    private String wrapper(List<Long> array) {
        StringBuilder sb = new StringBuilder();
        for (Long aLong : array) {
            sb.append(random.charAt(aLong.intValue()));
        }
        return sb.toString();
    }

}
