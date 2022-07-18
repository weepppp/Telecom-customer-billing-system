package com.tang.telecom.Exception;

import com.tang.telecom.units.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author weepppp 2022/7/11 23:10
 **/
@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public R exceptionHandler(IllegalArgumentException e) {
        return R.error("不合法的参数异常");
    }

}
