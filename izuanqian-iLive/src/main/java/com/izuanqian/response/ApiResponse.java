package com.izuanqian.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by root on 17-3-5.
 */
@Data
public class ApiResponse {

    @NonNull
    @ApiModelProperty("ok?")
    private boolean ok = true;
    @ApiModelProperty("response code")
    private int code = 0;
    @ApiModelProperty("response message")
    private String message;

    public static final Ok Ok = new Ok();
}
