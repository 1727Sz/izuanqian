package com.izuanqian.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by root on 17-3-5.
 */
@Data
@NoArgsConstructor
public class Ok extends ApiResponse {

    private Object obj;

    public Ok(String message) {
        super();
        this.setMessage(message);
    }


    public Ok(Object obj) {
        super();
        this.obj = obj;
    }

    public Ok(Object obj, String message) {
        super();
        this.obj = obj;
        this.setMessage(message);
    }

}
