package com.izuanqian;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by root on 17-3-8.
 */
@Data
@Builder
public class UrlConvertVO {

    @ApiModelProperty("url")
    private String url;
    @ApiModelProperty("the original url")
    private String originalUrl;
}
