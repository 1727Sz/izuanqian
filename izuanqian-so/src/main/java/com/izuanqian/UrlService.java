package com.izuanqian;

import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.izuanqian.redis.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by sanlion on 2017/2/22.
 */
@Service
public class UrlService {

    @Autowired
    private UrlMapper urlMapper;
    @Value("${cn.ilive.so.domain}")
    private String domain;
    @Autowired
    private UrlGenerator urlGenerator;
    @Autowired
    private Redis redis;

    /**
     * get url
     *
     * @param originalUrl
     * @return
     * @throws UnsupportedEncodingException
     */
    public UrlConvert get(String originalUrl) throws UnsupportedEncodingException {
        String md5Code =
                Hashing
                        .md5()
                        .newHasher()
                        .putString(originalUrl, Charset.forName("UTF-8"))
                        .hash()
                        .toString();
        String url = urlMapper.getUrlByMd5Code(md5Code);
        if (Strings.isNullOrEmpty(url)) {
            url = urlGenerator.nextUrl();
            urlMapper.saveUrl(url, originalUrl, md5Code);
            redis.save(url, originalUrl);
        }
        return UrlConvert
                .builder()
                .md5Code(md5Code)
                .originalUrl(originalUrl)
                .url(url)
                .build();
    }
}
