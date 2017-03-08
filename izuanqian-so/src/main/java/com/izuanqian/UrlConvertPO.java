package com.izuanqian;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by root on 17-3-8.
 */
@Data
public class UrlConvertPO {

    @ApiModelProperty("the url witch to be convert.")
    private String url;
}
