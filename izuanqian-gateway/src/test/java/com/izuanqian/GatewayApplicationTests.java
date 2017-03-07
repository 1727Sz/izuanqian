package com.izuanqian;

import com.izuanqian.redis.Redis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayApplicationTests {

    @Autowired
    Redis redis;

    @Test
    public void contextLoads() {

        Set<TokenManager.Token> tokens = new HashSet<>();
        tokens.add(new TokenManager.Token("0284092842", "iOS", "deviceToken", "aString", new Date()));
        tokens.add(new TokenManager.Token("0284092843", "Android", "deviceToken", "aString", new Date()));
        tokens.add(new TokenManager.Token("0284092841", "iOS", "deviceToken", "aString", new Date()));
        redis
                .a("token:20902", tokens);
    }

    @Test
    public void testMembers(){
        Set<TokenManager.Token> members = redis.members("token:20902", TokenManager.Token.class);
        System.out.println(members);
    }

}
