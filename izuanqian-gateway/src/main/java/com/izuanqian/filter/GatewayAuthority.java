package com.izuanqian.filter;

import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by root on 17-3-7.
 */
@Service
public class GatewayAuthority {

    private static final String KEY_SIGN = "sign";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_TOKEN = "token";

    @Value("${api.auth.sign.salt}")
    private String salt;
    @Value("${api.auth.time}")
    private int validSecond;

    /**
     * check whether sign is ok
     *
     * @param request
     * @return
     */
    public boolean isSignValid(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> signArgs = new TreeMap<>();
        String sign = null;
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            if (Arrays.asList(KEY_TIMESTAMP, KEY_TOKEN).contains(key)) {
                signArgs.put(key, request.getHeader(key));
            }
            if (KEY_SIGN.equals(key)) {
                sign = request.getHeader(key);
            }
        }
        if (Strings.isNullOrEmpty(sign)) {
            return false;
        }
        StringBuffer sb = new StringBuffer(salt);
        signArgs.forEach((key, value) -> sb.append(value));

        return sign.
                equalsIgnoreCase(
                        Hashing
                                .md5()
                                .newHasher()
                                .putString(sb.toString(), Charset.forName("UTF-8"))
                                .hash()
                                .toString()
                );
    }

    /**
     * Verify that the request is within the specified time period
     *
     * @param request
     * @return
     */
    public boolean isTimeValid(HttpServletRequest request) {
        String timestampStr = request.getHeader(KEY_TIMESTAMP);
        if (Strings.isNullOrEmpty(timestampStr)) {
            return false;
        }
        if (!Arrays.asList(10, 13).contains(timestampStr.length())) {
            return false;
        }
        timestampStr = timestampStr.length() == 10 ? timestampStr + "000" : timestampStr;
        long timestamp;
        try {
            timestamp = Long.parseLong(timestampStr);
        } catch (Exception e) {
            return false;
        }
        System.out.println(timestamp);
        long now = System.currentTimeMillis();
        return Math.abs(now - timestamp) < validSecond * 1000;
    }
}
