package com.izuanqian.exception;

import com.izuanqian.response.ApiResponse;
import com.izuanqian.response.Fail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 17-3-6.
 */
@RestController
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ApiResponse defaultExceptionHandler(Exception exception) {
        return new Fail(201703061, exception.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public ApiResponse bizExceptionHandler(BizException exception) {
        System.out.println(exception.getMessage());
        return new Fail(exception.getCode(), exception.getMessage());
    }
}
