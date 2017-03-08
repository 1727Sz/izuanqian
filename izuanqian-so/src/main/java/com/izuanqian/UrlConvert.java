package com.izuanqian;

import lombok.Builder;
import lombok.Data;

/**
 * Created by root on 17-3-8.
 */
@Data
@Builder
public class UrlConvert {

    private String url;
    private String originalUrl;
    private String md5Code;
}
