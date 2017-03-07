package com.izuanqian.response;

import lombok.Data;

/**
 * Created by root on 17-3-5.
 */
@Data
public class Fail extends ApiResponse {

    public Fail(int code, String message) {
        super();
        this.setOk(false);
        this.setCode(code);
        this.setMessage(message);
    }
}
