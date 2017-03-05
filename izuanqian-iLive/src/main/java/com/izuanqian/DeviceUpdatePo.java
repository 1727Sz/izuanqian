package com.izuanqian;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by root on 17-3-5.
 */
@Data
public class DeviceUpdatePo {

    @ApiModelProperty("device code")
    private String deviceCode;
    @ApiModelProperty("push device code")
    private String pushDeviceCode;
}
