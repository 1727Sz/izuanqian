/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izuanqian;

import com.google.common.base.Strings;
import com.google.common.io.BaseEncoding;
import com.izuanqian.redis.Redis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sanlion
 */
@Component
public class TokenManager {

    public void hand(Token token) {
        System.out.println(token);
    }

    public String hand(String authorization) {
        if (!Strings.isNullOrEmpty(authorization)) {
            String token = authorization.split(" ")[1];
            token = new String(BaseEncoding.base64().decode(token)).split(":")[1];
            return token;

        }
        return "-";
    }

    @Autowired
    private Redis redis;

    public void hand(HttpServletRequest request) {
        String deviceType = request.getHeader("Device-Type");
        String deviceToken = request.getHeader("Device-Token");
        String token = hand(request.getHeader(HttpHeaders.AUTHORIZATION));
        System.out.println(deviceToken);
        System.out.println(deviceType);
        String key = Key.__("token:{0}", token);
//        redis.set(key, new Token(token, deviceType, deviceToken, null, new Date()).toString());
    }

    @Data
    @AllArgsConstructor
    public static class Token implements Serializable {

        private static final long serialVersionUID = -3895376430072976951L;

        @NonNull
        private String token;
        @NonNull
        private String deviceType;
        @NonNull
        private String deviceToken;
        private String aString;
        @NonNull
        private Date date;
    }
}
