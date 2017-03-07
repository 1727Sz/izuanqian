package com.izuanqian.response;

import lombok.Data;
import lombok.NonNull;

/**
 * Created by root on 17-3-5.
 */
@Data
public class ApiResponse {

    @NonNull
    private boolean ok = true;
    private int code = 0;
    private String message;

    public static final Ok Ok = new Ok();
}
